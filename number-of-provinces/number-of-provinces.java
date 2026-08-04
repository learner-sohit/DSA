/**
 * 547. Number of Provinces
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/number-of-provinces/
 *
 * There are n cities. Some of them are connected directly; others are not.
 * If city a is connected to city b, and city b is connected to city c,
 * then city a is connected to city c. A province is a group of directly or
 * indirectly connected cities with no other cities outside the group.
 *
 * Given an n x n matrix isConnected where isConnected[i][j] == 1 if city i
 * and city j are directly connected, return the total number of provinces.
 */

class Solution {

    // Approach: Union-Find with path compression and union by size.
    // Time Complexity: O(V^2 * alpha(V)); Space Complexity: O(V).

    private class DisjointSet {
        private int[] parent;
        private int[] rank;
        private int[] size;

        DisjointSet(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            size = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findParent(int node) {
            if (node == parent[node]) {
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }

        void unionBySize(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);

            if (pu == pv) {
                return;
            }

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    ds.unionBySize(i, j);
                }
            }
        }

        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findParent(i) == i) {
                provinces++;
            }
        }

        return provinces;
    }

    /*
    // Alternate approach: DFS on the adjacency matrix.
    public int findCircleNumDfs(int[][] isConnected) {
        int provinces = 0;
        boolean[] visited = new boolean[isConnected.length];

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited);
                provinces++;
            }
        }

        return provinces;
    }

    private void dfs(int node, int[][] isConnected, boolean[] visited) {
        visited[node] = true;

        for (int neighbor = 0; neighbor < isConnected[node].length; neighbor++) {
            if (isConnected[node][neighbor] == 1 && !visited[neighbor]) {
                dfs(neighbor, isConnected, visited);
            }
        }
    }
    */
}

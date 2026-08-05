/**
 * 1319. Number of Operations to Make Network Connected
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 */
class Solution {

    // Union-Find counts redundant cables and the remaining connected components.
    // Time Complexity: O(E * alpha(N)); Space Complexity: O(N).
    private class DisjointSet {
        private int[] parent;
        private int[] size;

        DisjointSet(int n) {
            parent = new int[n + 1];
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

    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extraConnections = 0;

        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];

            if (ds.findParent(u) == ds.findParent(v)) {
                extraConnections++;
            } else {
                ds.unionBySize(u, v);
            }
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findParent(i) == i) {
                components++;
            }
        }

        return extraConnections >= components - 1 ? components - 1 : -1;
    }
}

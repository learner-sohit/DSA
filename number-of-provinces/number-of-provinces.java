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

    // -------------------------------------------------------------------------
    // Approach: DFS on Adjacency Matrix
    // -------------------------------------------------------------------------
    // Treat the matrix as an implicit graph. For each unvisited node, run a DFS
    // to mark all nodes in its connected component as visited, then increment
    // the province counter.
    //
    // Time Complexity:  O(V^2) — for each node we scan its entire row
    // Space Complexity: O(V)   — visited array + recursion call stack
    // -------------------------------------------------------------------------

    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int v = isConnected.length;
        boolean[] isVisited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!isVisited[i]) {
                dfs(i, isConnected, isVisited);
                provinces++;
            }
        }

        return provinces;
    }

    private void dfs(int node, int[][] isConnected, boolean[] isVisited) {
        isVisited[node] = true;

        for (int j = 0; j < isConnected[node].length; j++) {
            if (isConnected[node][j] == 1 && !isVisited[j]) {
                dfs(j, isConnected, isVisited);
            }
        }
    }
}

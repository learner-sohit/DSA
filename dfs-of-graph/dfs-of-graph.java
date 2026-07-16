import java.util.ArrayList;

/**
 * DFS of Graph
 * Platform: GeeksforGeeks
 * Link: https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
 *
 * Given a connected undirected graph represented as an adjacency list,
 * perform a Depth First Search (DFS) starting from vertex 0
 * and return the DFS traversal order.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: DFS using Recursion
    // -------------------------------------------------------------------------
    // Start from source node 0, use a visited array to avoid revisiting nodes.
    // Recursively visit each unvisited neighbor before backtracking.
    //
    // Time Complexity:  O(V + E) — each vertex and edge is processed once
    // Space Complexity: O(V)     — visited array + recursion call stack
    // -------------------------------------------------------------------------

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] isVisited = new boolean[adj.size()];

        dfs(0, ans, isVisited, adj);
        return ans;
    }

    private void dfs(int src, ArrayList<Integer> ans, boolean[] isVisited, ArrayList<ArrayList<Integer>> adj) {
        isVisited[src] = true;
        ans.add(src);

        for (int x : adj.get(src)) {
            if (!isVisited[x]) {
                dfs(x, ans, isVisited, adj);
            }
        }
    }
}

import java.util.ArrayList;

/**
 * Detect Cycle in a Directed Graph
 * Platform: GeeksforGeeks
 * Link: https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
 *
 * Given a directed graph with V vertices and a list of directed edges,
 * determine whether the graph contains a cycle.
 * Return true if a cycle exists, false otherwise.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: DFS with Path-Visited Tracking
    // -------------------------------------------------------------------------
    // In a directed graph, a cycle exists only if we reach a node that is
    // already on the CURRENT DFS path (not just any visited node).
    // We maintain two arrays:
    //   - visited[]     : marks nodes visited in any DFS call (global)
    //   - pathVisited[] : marks nodes on the current active DFS path (local)
    // On backtracking, pathVisited[node] is reset to false.
    // The outer loop handles disconnected components.
    //
    // Time Complexity:  O(V + E) — each vertex and edge is processed once
    // Space Complexity: O(V)     — two boolean arrays + recursion call stack
    // -------------------------------------------------------------------------

    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]); // directed edge u → v
        }

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, pathVisited, adj)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, boolean[] visited, boolean[] pathVisited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int adjNode : adj.get(node)) {
            if (!visited[adjNode]) {
                if (dfs(adjNode, visited, pathVisited, adj)) return true;
            } else if (pathVisited[adjNode]) {
                return true; // back edge → cycle found
            }
        }

        pathVisited[node] = false; // backtrack
        return false;
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
    // Approach 1: BFS — Kahn's Algorithm (Topological Sort)
    // -------------------------------------------------------------------------
    // If the graph is a DAG (no cycles), Kahn's algorithm can process all V
    // nodes in topological order. If any nodes are left unprocessed (count < V),
    // it means they are part of a cycle.
    //
    // Steps:
    //   1. Build adjacency list and compute in-degree for each node.
    //   2. Enqueue all nodes with in-degree 0.
    //   3. BFS: for each dequeued node, reduce neighbors' in-degrees;
    //      enqueue any neighbor whose in-degree drops to 0.
    //   4. If processed count < V → cycle exists.
    //
    // Time Complexity:  O(V + E)
    // Space Complexity: O(V + E) — adjacency list + queue + in-degree array
    // -------------------------------------------------------------------------

    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        int[] indegree = new int[V];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) q.offer(adjNode);
            }
        }

        return count != V; // if count < V, remaining nodes form a cycle
    }

    // -------------------------------------------------------------------------
    // Approach 2: DFS with Path-Visited Tracking
    // -------------------------------------------------------------------------
    // In a directed graph, a cycle exists only if we reach a node that is
    // already on the CURRENT DFS path (not just any visited node).
    // We maintain two arrays:
    //   - visited[]     : marks nodes visited in any DFS call (global)
    //   - pathVisited[] : marks nodes on the current active DFS path (local)
    // On backtracking, pathVisited[node] is reset to false.
    // The outer loop handles disconnected components.
    //
    // Time Complexity:  O(V + E)
    // Space Complexity: O(V) — two boolean arrays + recursion call stack
    // -------------------------------------------------------------------------

    /*
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
    */
}

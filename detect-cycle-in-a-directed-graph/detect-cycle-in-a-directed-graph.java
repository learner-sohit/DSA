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

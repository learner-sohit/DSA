import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Shortest Path in a DAG (Directed Acyclic Graph)
 * Platform: GeeksforGeeks
 * Link: https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
 *
 * Given a weighted DAG with V vertices and E edges, find the shortest path
 * from source node 0 to all other nodes.
 * Return -1 for nodes unreachable from source.
 */

class Solution {

    // Helper class to represent a neighbor with its edge weight
    class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    // -------------------------------------------------------------------------
    // Approach: Topological Sort (DFS) + Relaxation
    // -------------------------------------------------------------------------
    // In a DAG, we can compute shortest paths more efficiently than Dijkstra
    // by processing nodes in topological order. Since a DAG has no cycles,
    // topological order guarantees that when we process a node, all nodes
    // that could update its distance have already been processed.
    //
    // Steps:
    //   1. Build a directed weighted adjacency list.
    //   2. Run DFS-based topological sort → push nodes to a stack in finish order.
    //   3. Initialize dist[0] = 0, all others = MAX_VALUE.
    //   4. Pop nodes from the stack (topological order) and relax edges:
    //      if dist[node] + wt < dist[v] → update dist[v].
    //   5. Replace any remaining MAX_VALUE with -1 (unreachable nodes).
    //
    // Time Complexity:  O(V + E) — topological sort + single relaxation pass
    // Space Complexity: O(V + E) — adjacency list + dist array + visited + stack
    // -------------------------------------------------------------------------

    private void dfs(int node, ArrayList<ArrayList<Pair>> adj, boolean[] visited, Stack<Integer> st) {
        visited[node] = true;
        for (Pair adjNode : adj.get(node)) {
            if (!visited[adjNode.node]) {
                dfs(adjNode.node, adj, visited, st);
            }
        }
        st.push(node); // push after all descendants are processed
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(v, wt)); // directed weighted edge
        }

        // Step 1: Topological sort via DFS
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) dfs(i, adj, visited, st);
        }

        // Step 2: Relax edges in topological order
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while (!st.isEmpty()) {
            int node = st.pop();
            if (dist[node] != Integer.MAX_VALUE) {
                for (Pair nei : adj.get(node)) {
                    if (dist[node] + nei.weight < dist[nei.node]) {
                        dist[nei.node] = dist[node] + nei.weight;
                    }
                }
            }
        }

        // Step 3: Mark unreachable nodes as -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Shortest Path in Undirected Graph
 * Platform: GeeksforGeeks
 * Link: https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
 *
 * Given an undirected graph with V vertices and unit-weight edges,
 * find the shortest path (in terms of number of edges) from src to dest.
 * Return -1 if no path exists.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: BFS (Shortest Path in Unweighted Graph)
    // -------------------------------------------------------------------------
    // In an unweighted graph, BFS naturally finds the shortest path because
    // it explores nodes level by level (each level = one edge away from src).
    // We track the shortest distance to each node in a dist[] array,
    // initialized to Integer.MAX_VALUE (unvisited).
    //
    // Steps:
    //   1. Build an undirected adjacency list from edges.
    //   2. Set dist[src] = 0 and enqueue src.
    //   3. BFS: for each dequeued node, if it is dest → return dist[node].
    //      For each neighbor, if a shorter path is found, update dist and enqueue.
    //   4. After BFS, if dist[dest] is still MAX_VALUE → no path → return -1.
    //
    // Time Complexity:  O(V + E)
    // Space Complexity: O(V + E) — adjacency list + dist array + queue
    // -------------------------------------------------------------------------

    public int shortestPath(int V, int[][] edges, int src, int dest) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] node : edges) {
            int u = node[0];
            int v = node[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        dist[src] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            if (node == dest) return dist[node]; // early exit on reaching dest

            for (int adjNode : adj.get(node)) {
                if (dist[node] + 1 < dist[adjNode]) {
                    dist[adjNode] = dist[node] + 1;
                    q.offer(adjNode);
                }
            }
        }

        // Reaching here means dest was never dequeued → no path exists
        return -1;
        // Alternatively: return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }
}

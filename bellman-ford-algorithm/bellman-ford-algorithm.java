import java.util.Arrays;

/**
 * Bellman-Ford Algorithm
 * Platform: GeeksforGeeks
 * Link: https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
 *
 * Given a directed weighted graph with V vertices and a list of edges,
 * find the shortest distance from source src to all vertices.
 * Return {-1} if a negative weight cycle is detected.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: Bellman-Ford Algorithm
    // Time Complexity:  O(V × E) — V-1 relaxation passes over all edges
    // Space Complexity: O(V)     — dist array
    // -------------------------------------------------------------------------

    public int[] bellmanFord(int V, int[][] edges, int src) {
        int INF = (int) 1e8;
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        // Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], wt = edge[2];
                if (dist[u] != INF && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Nth iteration — detect negative weight cycle
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            if (dist[u] != INF && dist[u] + wt < dist[v]) {
                return new int[]{-1}; // negative cycle exists
            }
        }

        return dist;
    }
}

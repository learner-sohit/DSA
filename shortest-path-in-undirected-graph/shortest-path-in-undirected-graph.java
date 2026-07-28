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

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Minimum Spanning Tree (Prim's Algorithm)
 * Platform: GeeksforGeeks
 * Link: https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
 *
 * Given a weighted undirected graph with V vertices and a list of edges,
 * find the sum of weights of the edges in the Minimum Spanning Tree (MST).
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: Prim's Algorithm (Greedy + Min-Heap)
    // Time Complexity:  O((V + E) log V) — each node/edge processed with heap ops
    // Space Complexity: O(V + E)         — adjacency list + visited array + heap
    // -------------------------------------------------------------------------

    public int spanningTree(int V, int[][] edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new int[]{v, wt}); // undirected
            adj.get(v).add(new int[]{u, wt});
        }

        boolean[] visited = new boolean[V];

        // Min-heap ordered by edge weight: [wt, node]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0}); // start from node 0 with weight 0

        int sum = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int wt   = curr[0];
            int node = curr[1];

            if (visited[node]) continue; // skip already included nodes

            visited[node] = true;
            sum += wt; // include this edge's weight in MST

            for (int[] nei : adj.get(node)) {
                int adjNode = nei[0];
                int edgeWt  = nei[1];
                if (!visited[adjNode]) {
                    pq.offer(new int[]{edgeWt, adjNode});
                }
            }
        }

        return sum;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Dijkstra's Algorithm
 * Platform: GeeksforGeeks
 * Link: https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
 *
 * Given a weighted undirected graph with V vertices and a list of edges,
 * find the shortest distance from source node src to all other nodes.
 * Return -1 for nodes unreachable from src.
 */

class Solution {

    // Helper class to store a node and its associated edge weight / distance
    class Pair {
        int val; // node index
        int wt;  // distance or edge weight

        Pair(int val, int wt) {
            this.val = val;
            this.wt = wt;
        }
    }

    // -------------------------------------------------------------------------
    // Approach: Dijkstra's Algorithm (Min-Heap / Priority Queue)
    // -------------------------------------------------------------------------
    // Greedy shortest-path algorithm for graphs with non-negative edge weights.
    // Always processes the node with the smallest known distance first using a
    // min-heap (PriorityQueue ordered by weight).
    //
    // Key optimisation — stale entry check:
    //   When a shorter path to a node is found later, the old (larger) entry
    //   in the PQ becomes stale. We skip it with: if (p.wt > dist[p.val]) continue.
    //
    // Steps:
    //   1. Build an undirected weighted adjacency list.
    //   2. Initialize dist[] = MAX_VALUE; dist[src] = 0.
    //   3. Enqueue (src, 0) into min-heap.
    //   4. Poll smallest-distance node; skip if stale.
    //      For each neighbor, if relaxation improves distance, update and enqueue.
    //   5. Replace MAX_VALUE entries with -1 (unreachable nodes).
    //
    // Time Complexity:  O((V + E) log V) — each node/edge processed with heap ops
    // Space Complexity: O(V + E)         — adjacency list + dist array + heap
    // -------------------------------------------------------------------------

    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt)); // undirected
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Min-heap ordered by distance
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            // Skip stale entries (a shorter path was already found)
            if (p.wt > dist[p.val]) continue;

            for (Pair nei : adj.get(p.val)) {
                if (dist[p.val] + nei.wt < dist[nei.val]) {
                    dist[nei.val] = dist[p.val] + nei.wt;
                    pq.offer(new Pair(nei.val, dist[nei.val]));
                }
            }
        }

        // Mark unreachable nodes as -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }
}

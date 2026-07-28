import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

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
    // Approach 1: Dijkstra's Algorithm (TreeSet)
    // Time Complexity:  O((V + E) log V) — each update does O(log V) TreeSet ops
    // Space Complexity: O(V + E)         — adjacency list + dist array + TreeSet
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

        // TreeSet ordered by weight; tie-break by node index for uniqueness
        TreeSet<Pair> set = new TreeSet<>((a, b) -> a.wt != b.wt ? a.wt - b.wt : a.val - b.val);
        set.add(new Pair(src, 0));

        while (!set.isEmpty()) {
            Pair p = set.pollFirst();

            for (Pair nei : adj.get(p.val)) {
                if (dist[p.val] + nei.wt < dist[nei.val]) {
                    // Remove stale entry before updating (TreeSet allows exact removal)
                    set.remove(new Pair(nei.val, dist[nei.val]));
                    dist[nei.val] = dist[p.val] + nei.wt;
                    set.add(new Pair(nei.val, dist[nei.val]));
                }
            }
        }

        // Mark unreachable nodes as -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }

    // -------------------------------------------------------------------------
    // Approach 2: Dijkstra's Algorithm (PriorityQueue / Min-Heap)
    // Time Complexity:  O((V + E) log V)
    // Space Complexity: O(V + E)
    // -------------------------------------------------------------------------

    /*
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.wt > dist[p.val]) continue; // skip stale entries
            for (Pair nei : adj.get(p.val)) {
                if (dist[p.val] + nei.wt < dist[nei.val]) {
                    dist[nei.val] = dist[p.val] + nei.wt;
                    pq.offer(new Pair(nei.val, dist[nei.val]));
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }
    */
}

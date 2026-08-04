import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Minimum Spanning Tree (Kruskal's Algorithm)
 * Platform: GeeksforGeeks
 * Link: https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
 *
 * Given a weighted undirected graph with V vertices and a list of edges,
 * find the sum of weights of the edges in the Minimum Spanning Tree (MST).
 */

class Solution {

    // Disjoint Set (Union-Find) — supports both Union by Rank and Union by Size
    class DisjointSet {
        int[] parent, rank, size;

        DisjointSet(int n) {
            parent = new int[n + 1];
            rank   = new int[n + 1];
            size   = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                size[i]   = 1;
            }
        }

        int findParent(int node) {
            if (node == parent[node]) return node;
            return parent[node] = findParent(parent[node]); // path compression
        }

        void unionByRank(int u, int v) {
            int pu = findParent(u), pv = findParent(v);
            if (pu == pv) return;
            if (rank[pu] < rank[pv])      parent[pu] = pv;
            else if (rank[pv] < rank[pu]) parent[pv] = pu;
            else { parent[pv] = pu; rank[pu]++; }
        }

        void unionBySize(int u, int v) {
            int pu = findParent(u), pv = findParent(v);
            if (pu == pv) return;
            if (size[pu] < size[pv]) { parent[pu] = pv; size[pv] += size[pu]; }
            else                     { parent[pv] = pu; size[pu] += size[pv]; }
        }
    }

    // -------------------------------------------------------------------------
    // Approach 1: Kruskal's Algorithm (Sort Edges + Union-Find)
    // Time Complexity:  O(E log E) — sorting edges dominates
    // Space Complexity: O(V)       — Disjoint Set arrays
    // -------------------------------------------------------------------------

    public int spanningTree(int V, int[][] edges) {
        Arrays.sort(edges, (a, b) -> a[2] - b[2]); // sort by edge weight ascending
        DisjointSet ds = new DisjointSet(V);
        int mstWt = 0;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            if (ds.findParent(u) != ds.findParent(v)) { // no cycle
                mstWt += wt;
                ds.unionBySize(u, v);
            }
        }

        return mstWt;
    }

    // -------------------------------------------------------------------------
    // Approach 2: Prim's Algorithm (Greedy + Min-Heap)
    // Time Complexity:  O((V + E) log V)
    // Space Complexity: O(V + E)
    // -------------------------------------------------------------------------

    /*
    public int spanningTree(int V, int[][] edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0}); // [wt, node]
        int sum = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int wt = curr[0], node = curr[1];
            if (visited[node]) continue;
            visited[node] = true;
            sum += wt;
            for (int[] nei : adj.get(node)) {
                if (!visited[nei[0]]) pq.offer(new int[]{nei[1], nei[0]});
            }
        }
        return sum;
    }
    */
}

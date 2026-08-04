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

    // Disjoint Set (Union-Find) with path compression, union by rank, and union by size.
    class DisjointSet {
        int[] parent;
        int[] rank;
        int[] size;

        public DisjointSet(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            size = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
                size[i] = 1;
            }
        }

        public int findParent(int node) {
            if (node == parent[node]) {
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }

        public void unionByRank(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);

            if (pu == pv) return;
            if (rank[pu] < rank[pv]) {
                parent[pu] = pv;
            } else if (rank[pv] < rank[pu]) {
                parent[pv] = pu;
            } else {
                parent[pv] = pu;
                rank[pu]++;
            }
        }

        public void unionBySize(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);

            if (pu == pv) return;
            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }

    // Approach 1: Kruskal's Algorithm (Sort Edges + Union-Find)
    // Sort edges by weight and use Union-Find to add only non-cycle edges.
    // Time Complexity: O(E log E)
    // Space Complexity: O(V)

    public int spanningTree(int V, int[][] edges) {
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        DisjointSet ds = new DisjointSet(V);

        int mstWt = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (ds.findParent(u) != ds.findParent(v)) {
                mstWt += wt;
                ds.unionBySize(u, v);
            }
        }

        return mstWt;
    }

    // Approach 2: Prim's Algorithm (Greedy + Min-Heap)
    // Grow the MST by always choosing the cheapest edge to an unvisited node.
    // Time Complexity: O((V + E) log V)
    // Space Complexity: O(V + E)

    /*
    public int spanningTree(int V, int[][] edges) {
        boolean[] visited = new boolean[V];

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[] {v, wt});
            adj.get(v).add(new int[] {u, wt});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0}); // [wt, node]
        int sum = 0;

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int wt = edge[0];
            int node = edge[1];

            if (visited[node]) continue;
            visited[node] = true;
            sum += wt;

            for (int[] adArr : adj.get(node)) {
                int adjNode = adArr[0];
                int edw = adArr[1];

                if (!visited[adjNode]) {
                    pq.offer(new int[] {edw, adjNode});
                }
            }
        }

        return sum;
    }
    */
}

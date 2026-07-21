import java.util.LinkedList;
import java.util.Queue;

/**
 * 785. Is Graph Bipartite?
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/is-graph-bipartite/
 *
 * A graph is bipartite if we can split its set of nodes into two independent
 * subsets A and B such that every edge connects a node in A to one in B.
 *
 * Given an adjacency list graph of n nodes, return true if it is bipartite.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: BFS 2-Coloring
    // -------------------------------------------------------------------------
    // Try to color the graph using 2 colors such that no two adjacent nodes
    // share the same color. Start each uncolored node with color 0 and assign
    // the opposite color (1 - color) to every neighbor via BFS.
    // If a neighbor already has the same color as the current node → not bipartite.
    // The outer loop handles disconnected graphs.
    //
    // Time Complexity:  O(V + E) — each node and edge is processed once
    // Space Complexity: O(V)     — color array + BFS queue
    // -------------------------------------------------------------------------

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        for (int i = 0; i < V; i++) color[i] = -1;  // -1 = uncolored

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                color[i] = 0;

                while (!q.isEmpty()) {
                    int node = q.poll();

                    for (int adjNode : graph[node]) {
                        if (color[adjNode] == -1) {
                            color[adjNode] = 1 - color[node];
                            q.offer(adjNode);
                        } else if (color[adjNode] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

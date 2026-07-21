import java.util.Arrays;
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
    // Approach 1: BFS 2-Coloring
    // -------------------------------------------------------------------------
    // Try to color the graph using 2 colors such that no two adjacent nodes
    // share the same color. Assign color 0 to the source and 1 - color to each
    // neighbor via BFS. If a neighbor already has the same color → not bipartite.
    //
    // Time Complexity:  O(V + E) — each node and edge is processed once
    // Space Complexity: O(V)     — color array + BFS queue
    // -------------------------------------------------------------------------

    /*
    public boolean isBipartite_bfs(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        for (int i = 0; i < V; i++) color[i] = -1;

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
    */

    // -------------------------------------------------------------------------
    // Approach 2: DFS 2-Coloring
    // -------------------------------------------------------------------------
    // Same 2-coloring logic but using recursive DFS. Assign color 0 to the
    // source, then recursively assign opposite colors to neighbors.
    // If a neighbor already has the same color as the current node → not bipartite.
    //
    // Time Complexity:  O(V + E) — each node and edge is processed once
    // Space Complexity: O(V)     — color array + recursion call stack
    // -------------------------------------------------------------------------

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                if (!dfs(i, graph, color)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int[][] graph, int[] color) {
        for (int adjNode : graph[node]) {
            if (color[adjNode] == -1) {
                color[adjNode] = 1 - color[node];
                if (!dfs(adjNode, graph, color)) return false;
            } else if (color[adjNode] == color[node]) {
                return false;
            }
        }
        return true;
    }
}

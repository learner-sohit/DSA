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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Detect Cycle in an Undirected Graph
 * Platform: GeeksforGeeks
 * Link: https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
 *
 * Given an undirected graph with V vertices and a list of edges, determine
 * whether the graph contains a cycle. Return true if a cycle exists, false otherwise.
 */

class Solution {

    class Pair {
        int val, parent;
        Pair(int val, int parent) {
            this.val = val;
            this.parent = parent;
        }
    }

    // -------------------------------------------------------------------------
    // Approach 1: BFS with Parent Tracking
    // -------------------------------------------------------------------------
    // For each unvisited vertex, run a BFS and track the parent of every node.
    // If we encounter an already-visited neighbor that is NOT the parent of the
    // current node, a cycle exists (back edge detected).
    // The outer loop handles disconnected graphs.
    //
    // Time Complexity:  O(V + E) — each vertex and edge is processed once
    // Space Complexity: O(V + E) — adjacency list + visited array + BFS queue
    // -------------------------------------------------------------------------

    /*
    public boolean isCycle_bfs(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] isVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                Queue<Pair> q = new LinkedList<>();
                q.offer(new Pair(i, -1));

                while (!q.isEmpty()) {
                    Pair node = q.poll();
                    int val = node.val;
                    int parent = node.parent;

                    for (int adjNode : adj.get(val)) {
                        if (!isVisited[adjNode]) {
                            isVisited[adjNode] = true;
                            q.offer(new Pair(adjNode, val));
                        } else if (parent != adjNode) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    */

    // -------------------------------------------------------------------------
    // Approach 2: DFS with Parent Tracking
    // -------------------------------------------------------------------------
    // For each unvisited vertex, run a DFS passing the parent along each call.
    // If we reach an already-visited neighbor that is NOT the parent of the
    // current node, a back edge is found → cycle detected.
    // The outer loop handles disconnected graphs.
    //
    // Time Complexity:  O(V + E) — each vertex and edge is processed once
    // Space Complexity: O(V + E) — adjacency list + visited array + call stack
    // -------------------------------------------------------------------------

    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] isVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                if (dfs(i, -1, isVisited, adj)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, int parent, boolean[] isVisited, ArrayList<ArrayList<Integer>> adj) {
        isVisited[node] = true;

        for (int adjNode : adj.get(node)) {
            if (!isVisited[adjNode]) {
                if (dfs(adjNode, node, isVisited, adj)) return true;
            } else if (parent != adjNode) {
                return true;
            }
        }
        return false;
    }
}

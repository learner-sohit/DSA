import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Connected Components in an Undirected Graph
 * Platform: GeeksforGeeks
 * Link: https://www.geeksforgeeks.org/problems/connected-components-in-an-undirected-graph/1
 *
 * Given an undirected graph with V vertices and a list of edges,
 * find all connected components. Return each component as a sorted
 * list of its vertices, and return all components as a list of lists.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: BFS for each unvisited node
    // -------------------------------------------------------------------------
    // Build an adjacency list from the edge list. Iterate over every vertex;
    // for each unvisited vertex, perform a BFS to collect all vertices reachable
    // from it into one component, then add that component to the answer.
    //
    // Time Complexity:  O(V + E) — each vertex and edge is processed once
    // Space Complexity: O(V + E) — adjacency list + visited array + BFS queue
    // -------------------------------------------------------------------------

    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] isVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                isVisited[i] = true;

                Queue<Integer> q = new LinkedList<>();
                q.offer(i);

                while (!q.isEmpty()) {
                    int node = q.poll();
                    component.add(node);

                    for (int x : adj.get(node)) {
                        if (!isVisited[x]) {
                            q.offer(x);
                            isVisited[x] = true;
                        }
                    }
                }
                ans.add(component);
            }
        }
        return ans;
    }
}

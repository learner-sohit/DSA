import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Connected Components in an Undirected Graph
 * Platform: GeeksforGeeks
 * Link: https://www.geeksforgeeks.org/problems/connected-components-in-an-undirected-graph/1
 *
 * Given an undirected graph with V vertices and a list of edges,
 * count the number of connected components.
 */

class Solution {

    // Approach 1: DFS for each unvisited node
    // Build an adjacency list and start a DFS whenever a new component is found.
    // Time Complexity: O(V + E)
    // Space Complexity: O(V + E)

    private void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (int adjNode : adj.get(node)) {
            if (!visited[adjNode]) {
                dfs(adjNode, visited, adj);
            }
        }
    }

    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        int components = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, visited, adj);
            }
        }

        return components;
    }

    // Approach 2: BFS for each unvisited node
    // Collect all vertices of every connected component.
    // Time Complexity: O(V + E)
    // Space Complexity: O(V + E)

    /*
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
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
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                isVisited[i] = true;
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
    */
}

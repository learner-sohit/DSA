import java.util.ArrayList;
import java.util.Stack;

/**
 * Topological Sort
 * Platform: GeeksforGeeks
 * Link: https://www.geeksforgeeks.org/problems/topological-sort/1
 *
 * Given a Directed Acyclic Graph (DAG) with V vertices and a list of directed
 * edges, return a valid topological ordering of its vertices.
 * In a topological order, for every directed edge u → v, vertex u appears
 * before vertex v in the ordering.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: DFS + Stack (Reverse Finish Order)
    // -------------------------------------------------------------------------
    // Run DFS on every unvisited node. After fully exploring all descendants
    // of a node (post-order), push it onto a stack. Since a node is pushed
    // only after all nodes it points to are pushed, popping the stack yields
    // a valid topological order.
    //
    // Time Complexity:  O(V + E) — each vertex and edge is processed once
    // Space Complexity: O(V)     — visited array + stack + recursion call stack
    // -------------------------------------------------------------------------

    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]); // directed edge u → v
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj, st);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans;
    }

    private void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        visited[node] = true;

        for (int adjNode : adj.get(node)) {
            if (!visited[adjNode]) {
                dfs(adjNode, visited, adj, st);
            }
        }

        st.push(node); // push after all descendants are processed
    }
}

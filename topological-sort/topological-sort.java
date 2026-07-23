import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
    // Approach 1: DFS + Stack (Reverse Finish Order)
    // -------------------------------------------------------------------------
    // Run DFS; after fully exploring all descendants of a node, push it onto
    // a stack. Popping the stack gives a valid topological order.
    //
    // Time Complexity:  O(V + E) — each vertex and edge is processed once
    // Space Complexity: O(V)     — visited array + stack + recursion call stack
    // -------------------------------------------------------------------------

    /*
    private void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        visited[node] = true;
        for (int adjNode : adj.get(node)) {
            if (!visited[adjNode]) dfs(adjNode, visited, adj, st);
        }
        st.push(node);
    }

    public ArrayList<Integer> topoSort_dfs(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) adj.get(edge[0]).add(edge[1]);

        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) dfs(i, visited, adj, st);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()) ans.add(st.pop());
        return ans;
    }
    */

    // -------------------------------------------------------------------------
    // Approach 2: BFS / Kahn's Algorithm (Indegree-based)
    // -------------------------------------------------------------------------
    // Compute the in-degree of every node. Enqueue all nodes with in-degree 0
    // (no prerequisites). Process each node: add it to the result, then
    // decrement the in-degree of its neighbors — enqueue any that reach 0.
    //
    // Time Complexity:  O(V + E) — each vertex and edge is processed once
    // Space Complexity: O(V)     — indegree array + BFS queue
    // -------------------------------------------------------------------------

    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) adj.get(edge[0]).add(edge[1]);

        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int node : adj.get(i)) indegree[node]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) q.offer(adjNode);
            }
        }
        return ans;
    }
}

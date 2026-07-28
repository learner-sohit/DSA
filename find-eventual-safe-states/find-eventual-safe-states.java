import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 802. Find Eventual Safe States
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/find-eventual-safe-states/
 *
 * A node is a "safe node" if every path starting from it eventually leads
 * to a terminal node (a node with no outgoing edges) or another safe node.
 * Return all safe nodes in sorted order.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: Reverse Graph + BFS (Kahn's Algorithm)
    // Time Complexity:  O(V + E + V log V) — BFS is O(V+E), sort is O(V log V)
    // Space Complexity: O(V + E) — reversed adjacency list + in-degree array + queue
    // -------------------------------------------------------------------------

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) adjRev.add(new ArrayList<>());

        int[] indegree = new int[V];

        for (int u = 0; u < V; u++) {
            for (int v : graph[u]) {
                adjRev.get(v).add(u); // reverse edge: v → u
                indegree[u]++;        // original out-degree of u
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.offer(i); // terminal nodes in original graph
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int adjNode : adjRev.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) q.offer(adjNode);
            }
        }

        Collections.sort(ans);
        return ans;
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS of Graph
 * Platform: GeeksforGeeks
 * Link: https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
 *
 * Given a directed graph represented as an adjacency list,
 * perform a Breadth First Search (BFS) starting from vertex 0
 * and return the BFS traversal order.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: BFS using Queue
    // -------------------------------------------------------------------------
    // Start from source node 0, use a visited array to avoid revisiting nodes.
    // Use a Queue to process nodes level by level.
    //
    // Time Complexity:  O(V + E) — each vertex and edge is processed once
    // Space Complexity: O(V)     — visited array + queue
    // -------------------------------------------------------------------------

    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] isVisited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();

        int src = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        isVisited[src] = true;

        while (!q.isEmpty()) {
            src = q.poll();
            ans.add(src);

            for (int x : adj.get(src)) {
                if (!isVisited[x]) q.offer(x);
                isVisited[x] = true;
            }
        }
        return ans;
    }
}

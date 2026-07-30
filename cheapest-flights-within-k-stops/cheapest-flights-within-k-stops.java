import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 787. Cheapest Flights Within K Stops
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/cheapest-flights-within-k-stops/
 *
 * Given n cities connected by flights [from, to, price], find the cheapest
 * price from src to dst with at most k stops. Return -1 if no such route exists.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: BFS with Stop Count (Modified Dijkstra)
    // Time Complexity:  O(n + flights × k) — BFS limited to k+1 levels
    // Space Complexity: O(n + flights)     — adjacency list + dist array + queue
    // -------------------------------------------------------------------------

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Queue entries: [stops used, node, cost so far]
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, src, 0});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int stops = current[0];
            int node  = current[1];
            int cost  = current[2];

            if (stops > k) continue; // exceeded allowed stops

            for (int[] nei : adj.get(node)) {
                int nextNode = nei[0];
                int edgeWt   = nei[1];

                if (cost + edgeWt < dist[nextNode] && stops <= k) {
                    dist[nextNode] = cost + edgeWt;
                    q.offer(new int[]{stops + 1, nextNode, cost + edgeWt});
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}

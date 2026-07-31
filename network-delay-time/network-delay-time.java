import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 743. Network Delay Time
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/network-delay-time/
 *
 * Given a directed weighted graph of n nodes and travel times,
 * find the minimum time for a signal sent from node k to reach all nodes.
 * Return -1 if it is impossible for all nodes to receive the signal.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: Dijkstra's Algorithm (Single Source Shortest Path)
    // Time Complexity:  O((N + E) log N) — each node/edge processed with heap ops
    // Space Complexity: O(N + E)         — adjacency list + dist array + heap
    // -------------------------------------------------------------------------

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] time : times) {
            adj.get(time[0]).add(new int[]{time[1], time[2]}); // directed: u → v with wt
        }

        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) dist[i] = Integer.MAX_VALUE;
        dist[k] = 0;

        // Min-heap ordered by travel time: [time, node]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];

            for (int[] next : adj.get(node)) {
                int adjNode = next[0];
                int adjTime = next[1];

                if (time + adjTime < dist[adjNode]) {
                    dist[adjNode] = time + adjTime;
                    pq.offer(new int[]{time + adjTime, adjNode});
                }
            }
        }

        // The answer is the maximum shortest distance across all nodes (except src)
        int ans = -1;
        for (int i = 1; i <= n; i++) {
            if (i == k) continue;
            ans = Math.max(ans, dist[i]);
        }

        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}

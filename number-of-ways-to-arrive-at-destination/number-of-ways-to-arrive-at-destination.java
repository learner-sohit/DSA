import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1976. Number of Ways to Arrive at Destination
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
 *
 * Given n intersections and roads [u, v, time], find the number of ways to
 * travel from node 0 to node n-1 in the shortest possible time.
 * Return the answer modulo 1_000_000_007.
 */

class Solution {

    int mod = 1_000_000_007;

    // -------------------------------------------------------------------------
    // Approach: Dijkstra's Algorithm + Way Count
    // Time Complexity:  O((N + E) log N)
    // Space Complexity: O(N + E)
    // -------------------------------------------------------------------------

    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] road : roads) {
            int u = road[0], v = road[1], wt = road[2];
            adj.get(u).add(new int[]{v, wt}); // undirected
            adj.get(v).add(new int[]{u, wt});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1; // one way to reach source

        // Min-heap: [node, time]
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node  = (int) curr[0];
            long time = curr[1];

            if (time > dist[node]) continue; // skip stale entries

            for (int[] next : adj.get(node)) {
                int adjNode  = next[0];
                int adjTime  = next[1];

                if (time + adjTime < dist[adjNode]) {
                    // Found a strictly shorter path — reset count
                    dist[adjNode] = time + adjTime;
                    ways[adjNode] = ways[node];
                    pq.offer(new long[]{adjNode, time + adjTime});
                } else if (time + adjTime == dist[adjNode]) {
                    // Found another path of equal length — add to count
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}

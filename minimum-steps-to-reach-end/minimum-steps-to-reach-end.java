import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Minimum Steps to Reach End
 * Platform: GeeksforGeeks
 * Link: https://www.geeksforgeeks.org/problems/minimum-steps-to-reach-end/0
 *
 * Given an array arr[] of multipliers, a start value, and an end value,
 * find the minimum number of multiplication steps to convert start to end,
 * where each step multiplies the current value by some element of arr[],
 * and all values are taken modulo 1000.
 * Return -1 if it is not possible.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: BFS on Modular State Space
    // Time Complexity:  O(1000 × |arr|) — at most 1000 unique states, each expanded once
    // Space Complexity: O(1000)          — dist array + BFS queue
    // -------------------------------------------------------------------------

    public int minSteps(int[] arr, int start, int end) {
        int mod = 1000;
        start = start % mod;

        if (start == end) return 0;

        int[] dist = new int[mod];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // BFS: [node, cost]
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int cost = curr[1];

            for (int next : arr) {
                int newNode = (node * next) % mod;

                if (cost + 1 < dist[newNode]) {
                    dist[newNode] = cost + 1;
                    if (newNode == end) return cost + 1; // early exit
                    q.offer(new int[]{newNode, cost + 1});
                }
            }
        }

        return -1;
    }
}

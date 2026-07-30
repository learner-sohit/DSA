import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1631. Path With Minimum Effort
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/path-with-minimum-effort/
 *
 * Given an n×m matrix of heights, find a path from top-left (0,0) to
 * bottom-right (n-1,m-1) such that the maximum absolute difference between
 * consecutive cells along the path is minimized. Return that minimum effort.
 */

class Solution {

    static class Pair {
        int row, col, diff;

        Pair(int row, int col, int diff) {
            this.row = row;
            this.col = col;
            this.diff = diff;
        }
    }

    // -------------------------------------------------------------------------
    // Approach: Dijkstra's Algorithm (Minimise Maximum Edge Weight)
    // Time Complexity:  O(N × M × log(N × M)) — each cell processed with heap ops
    // Space Complexity: O(N × M)               — effort array + priority queue
    // -------------------------------------------------------------------------

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int[][] effort = new int[n][m];
        for (int[] arr : effort) Arrays.fill(arr, Integer.MAX_VALUE);
        effort[0][0] = 0;

        // Min-heap ordered by current max effort along the path
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.diff - b.diff);
        pq.offer(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            // Early exit: first time we reach destination is guaranteed optimal
            if (p.row == n - 1 && p.col == m - 1) return p.diff;

            for (int i = 0; i < 4; i++) {
                int r = p.row + dr[i];
                int c = p.col + dc[i];
                if (r >= 0 && r < n && c >= 0 && c < m) {
                    int newEffort = Math.max(Math.abs(heights[r][c] - heights[p.row][p.col]), p.diff);
                    if (newEffort < effort[r][c]) {
                        effort[r][c] = newEffort;
                        pq.offer(new Pair(r, c, newEffort));
                    }
                }
            }
        }

        return effort[n - 1][m - 1];
    }
}

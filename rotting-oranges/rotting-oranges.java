import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. Rotting Oranges
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/rotting-oranges/
 *
 * You are given an m x n grid where each cell can have one of three values:
 *   0 — empty cell
 *   1 — fresh orange
 *   2 — rotten orange
 *
 * Every minute, any fresh orange 4-directionally adjacent to a rotten orange
 * becomes rotten. Return the minimum number of minutes until no fresh orange
 * remains, or -1 if it is impossible.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: Multi-source BFS
    // -------------------------------------------------------------------------
    // Enqueue all initially rotten oranges simultaneously (time = 0).
    // Spread rot level by level (minute by minute) using BFS.
    // Track the count of fresh oranges; if any remain after BFS, return -1.
    //
    // Time Complexity:  O(M * N) — every cell is visited at most once
    // Space Complexity: O(M * N) — BFS queue can hold all cells in the worst case
    // -------------------------------------------------------------------------

    class Pair {
        int row, col, time;
        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) q.offer(new Pair(i, j, 0));
                if (grid[i][j] == 1) fresh++;
            }
        }

        int maxTime = 0;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair node = q.poll();
            int row = node.row;
            int col = node.col;
            int time = node.time;

            maxTime = Math.max(maxTime, time);

            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1) {
                    grid[nrow][ncol] = 2;
                    fresh--;
                    q.offer(new Pair(nrow, ncol, time + 1));
                }
            }
        }

        return fresh == 0 ? maxTime : -1;
    }
}

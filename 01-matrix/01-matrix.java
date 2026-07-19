import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 Matrix
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/01-matrix/
 *
 * Given an m x n binary matrix mat, return the distance of the nearest 0
 * for each cell. The distance between two adjacent cells is 1.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: Multi-source BFS from all 0-cells simultaneously
    // -------------------------------------------------------------------------
    // Instead of running BFS from each 1-cell to find the nearest 0 (brute force),
    // we flip the perspective: enqueue ALL 0-cells at time 0 and spread outward.
    // Each 1-cell gets assigned the distance at the moment BFS first reaches it.
    //
    // Time Complexity:  O(M * N) — every cell is enqueued and processed at most once
    // Space Complexity: O(M * N) — visited array + BFS queue + answer array
    // -------------------------------------------------------------------------

    class Pair {
        int row, col, time;
        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        boolean[][] isVisited = new boolean[m][n];
        int[][] ans = new int[m][n];

        Queue<Pair> q = new LinkedList<>();

        // Seed BFS with all 0-cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new Pair(i, j, 0));
                    isVisited[i][j] = true;
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair node = q.poll();
            int row = node.row;
            int col = node.col;
            int time = node.time;

            ans[row][col] = time;

            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && !isVisited[nrow][ncol]) {
                    q.offer(new Pair(nrow, ncol, time + 1));
                    isVisited[nrow][ncol] = true;
                }
            }
        }

        return ans;
    }
}

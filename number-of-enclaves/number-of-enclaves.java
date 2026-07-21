/**
 * 1020. Number of Enclaves
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/number-of-enclaves/
 *
 * You are given an m x n binary matrix grid, where 0 represents sea and
 * 1 represents land. A land cell is an enclave if it cannot reach the boundary
 * of the grid by moving 4-directionally through land cells.
 * Return the number of land cells in the grid that are enclaves.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: Boundary DFS (same pattern as Surrounded Regions)
    // -------------------------------------------------------------------------
    // Mark all land cells reachable from the border using DFS — these are NOT
    // enclaves. Then count all remaining unvisited land cells in the interior.
    //
    // Note: Can be further optimized by marking visited land cells directly in
    // the grid (flipping 1 → 0) to avoid the separate visited array.
    //
    // Time Complexity:  O(M * N) — every cell is visited at most once
    // Space Complexity: O(M * N) — visited array + recursion call stack
    // -------------------------------------------------------------------------

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] isVisited = new boolean[n][m];

        // DFS from all border land cells to mark non-enclave regions
        for (int i = 0; i < m; i++) {
            if (!isVisited[0][i] && grid[0][i] == 1)       dfs(0, i, isVisited, grid);       // First row
            if (!isVisited[n - 1][i] && grid[n - 1][i] == 1) dfs(n - 1, i, isVisited, grid); // Last row
        }
        for (int j = 0; j < n; j++) {
            if (!isVisited[j][0] && grid[j][0] == 1)       dfs(j, 0, isVisited, grid);       // First column
            if (!isVisited[j][m - 1] && grid[j][m - 1] == 1) dfs(j, m - 1, isVisited, grid); // Last column
        }

        // Count all interior land cells that were never reached from the border
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j] && grid[i][j] == 1) count++;
            }
        }
        return count;
    }

    private void dfs(int row, int col, boolean[][] isVisited, int[][] grid) {
        isVisited[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = row + dr[i];
            int ncol = col + dc[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && grid[nrow][ncol] == 1 && !isVisited[nrow][ncol]) {
                dfs(nrow, ncol, isVisited, grid);
            }
        }
    }
}

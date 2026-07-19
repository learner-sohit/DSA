/**
 * 130. Surrounded Regions
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/surrounded-regions/
 *
 * Given an m x n board containing 'X' and 'O', capture all regions that are
 * 4-directionally surrounded by 'X'. A region is captured by flipping all
 * 'O's into 'X's in that surrounded region.
 *
 * An 'O' is NOT captured if it is on the border or connected to a border 'O'.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: Boundary DFS (Reverse Thinking)
    // -------------------------------------------------------------------------
    // Instead of finding surrounded regions directly, mark all 'O's that are
    // connected to the border (i.e., safe / not capturable) using DFS from
    // every border cell. Then flip all remaining unvisited 'O's to 'X'.
    //
    // Time Complexity:  O(M * N) — every cell is visited at most once
    // Space Complexity: O(M * N) — visited array + recursion call stack
    // -------------------------------------------------------------------------

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] isVisited = new boolean[m][n];

        // DFS from all border 'O' cells to mark safe regions
        for (int i = 0; i < n; i++) {            // First row
            if (board[0][i] == 'O' && !isVisited[0][i]) dfs(0, i, isVisited, board);
        }
        for (int i = 0; i < m; i++) {            // First column
            if (board[i][0] == 'O' && !isVisited[i][0]) dfs(i, 0, isVisited, board);
        }
        for (int i = 0; i < n; i++) {            // Last row
            if (board[m - 1][i] == 'O' && !isVisited[m - 1][i]) dfs(m - 1, i, isVisited, board);
        }
        for (int i = 0; i < m; i++) {            // Last column
            if (board[i][n - 1] == 'O' && !isVisited[i][n - 1]) dfs(i, n - 1, isVisited, board);
        }

        // Flip all unvisited 'O's — they are surrounded
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int col, boolean[][] isVisited, char[][] board) {
        isVisited[row][col] = true;
        int m = isVisited.length;
        int n = isVisited[0].length;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                    && !isVisited[nrow][ncol] && board[nrow][ncol] == 'O') {
                dfs(nrow, ncol, isVisited, board);
            }
        }
    }
}

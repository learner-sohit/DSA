import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. Number of Islands
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/number-of-islands/
 *
 * Given an m x n 2D binary grid of '1's (land) and '0's (water),
 * return the number of islands. An island is surrounded by water and
 * is formed by connecting adjacent lands horizontally or vertically.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: BFS — count connected components of land cells
    // -------------------------------------------------------------------------
    // For every unvisited land cell ('1'), increment the island count and run
    // BFS to mark the entire connected land region as visited. Repeat until
    // all cells are processed.
    //
    // Time Complexity:  O(M * N) — every cell is enqueued and processed at most once
    // Space Complexity: O(M * N) — visited array + BFS queue
    // -------------------------------------------------------------------------

    class Pair {
        int row, col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] isVisited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j] && grid[i][j] == '1') {
                    count++;
                    isVisited[i][j] = true;
                    bfs(i, j, isVisited, grid);
                }
            }
        }
        return count;
    }

    private void bfs(int row, int col, boolean[][] isVisited, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));

        while (!q.isEmpty()) {
            Pair node = q.poll();
            int r = node.row;
            int c = node.col;

            for (int i = 0; i < 4; i++) {
                int nrow = r + dr[i];
                int ncol = c + dc[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && grid[nrow][ncol] == '1' && !isVisited[nrow][ncol]) {
                    isVisited[nrow][ncol] = true;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }
    }
}

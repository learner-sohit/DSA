import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1091. Shortest Path in Binary Matrix
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/shortest-path-in-binary-matrix/
 *
 * Given an n×n binary matrix, find the shortest clear path from top-left (0,0)
 * to bottom-right (n-1,n-1) moving in 8 directions (including diagonals).
 * A clear path only passes through cells with value 0.
 * Return the path length (number of cells), or -1 if no clear path exists.
 */

class Solution {

    class Pair {
        int dis, row, col;

        Pair(int dis, int row, int col) {
            this.dis = dis;
            this.row = row;
            this.col = col;
        }
    }

    // -------------------------------------------------------------------------
    // Approach 1: Dijkstra-style BFS (dist array)
    // Time Complexity:  O(N²) — each cell visited at most once
    // Space Complexity: O(N²) — dist array + queue
    // -------------------------------------------------------------------------

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) return -1;

        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 1;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(1, 0, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 8; i++) {
                int r = p.row + dr[i];
                int c = p.col + dc[i];
                if (r >= 0 && r < n && c >= 0 && c < m
                        && grid[r][c] == 0
                        && p.dis + 1 < dist[r][c]) {
                    dist[r][c] = p.dis + 1;
                    q.offer(new Pair(p.dis + 1, r, c));
                }
            }
        }

        return dist[n - 1][m - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1][m - 1];
    }

    // -------------------------------------------------------------------------
    // Approach 2: Pure BFS (mark visited in-place)
    // Time Complexity:  O(N²)
    // Space Complexity: O(N²) — queue only; grid used as visited array
    // -------------------------------------------------------------------------

    /*
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) return -1;

        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1});
        grid[0][0] = 1; // mark visited in-place

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0], col = cur[1], dis = cur[2];

            if (row == n - 1 && col == m - 1) return dis;

            for (int i = 0; i < 8; i++) {
                int r = row + dr[i];
                int c = col + dc[i];
                if (r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 0) {
                    grid[r][c] = 1; // mark visited immediately
                    q.offer(new int[]{r, c, dis + 1});
                }
            }
        }

        return -1;
    }
    */
}

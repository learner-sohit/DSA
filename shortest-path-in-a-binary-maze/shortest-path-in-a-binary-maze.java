import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Shortest Path in a Binary Maze
 * Platform: GeeksforGeeks
 * Link: https://www.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1
 *
 * Given an n×m binary matrix where 1 = passable and 0 = blocked,
 * find the shortest path (in steps) from src to dest.
 * Return -1 if no path exists or src is blocked.
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
    // Approach: BFS on Grid (Unit-Weight Shortest Path)
    // Time Complexity:  O(N × M) — each cell visited at most once
    // Space Complexity: O(N × M) — dist array + BFS queue
    // -------------------------------------------------------------------------

    public int shortestPath(int[][] mat, int[] src, int[] dest) {
        if (mat[src[0]][src[1]] == 0) return -1; // source is blocked

        int n = mat.length, m = mat[0].length;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[src[0]][src[1]] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, src[0], src[1]));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int r = p.row + dr[i];
                int c = p.col + dc[i];

                if (r >= 0 && r < n && c >= 0 && c < m
                        && mat[r][c] == 1
                        && p.dis + 1 < dist[r][c]) {
                    dist[r][c] = p.dis + 1;
                    q.offer(new Pair(p.dis + 1, r, c));
                }
            }
        }

        return dist[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : dist[dest[0]][dest[1]];
    }
}

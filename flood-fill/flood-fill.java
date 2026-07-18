import java.util.LinkedList;
import java.util.Queue;

/**
 * 733. Flood Fill
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/flood-fill/
 *
 * You are given an image represented as an m x n integer grid, a starting
 * pixel (sr, sc), and a new color. Perform a flood fill starting from (sr, sc):
 * change the color of the starting pixel and all 4-directionally connected
 * pixels of the same original color to the new color. Return the modified image.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: BFS (Iterative Flood Fill)
    // -------------------------------------------------------------------------
    // Record the original color at (sr, sc). BFS outward, recoloring every
    // 4-directionally adjacent pixel that still has that original color.
    // An early-exit guard (original == new color) prevents an infinite loop.
    //
    // Time Complexity:  O(M * N) — each pixel is enqueued and processed at most once
    // Space Complexity: O(M * N) — BFS queue can hold all pixels in the worst case
    // -------------------------------------------------------------------------

    class Pair {
        int row, col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;

        int n = image.length;
        int m = image[0].length;
        int toChange = image[sr][sc];

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr, sc));
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            Pair pixel = q.poll();
            int row = pixel.row;
            int col = pixel.col;

            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == toChange) {
                    image[nrow][ncol] = color;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }

        return image;
    }
}

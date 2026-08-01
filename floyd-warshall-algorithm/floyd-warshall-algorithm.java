/**
 * Floyd-Warshall Algorithm
 * Platform: GeeksforGeeks
 * Link: https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
 *
 * Given a weighted directed graph represented as an n×n distance matrix,
 * compute the shortest distances between every pair of vertices.
 * Cells with value 1e8 represent no direct edge (infinity).
 * The matrix is modified in-place.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: Floyd-Warshall (All-Pairs Shortest Path)
    // Time Complexity:  O(V³) — three nested loops over all vertex pairs
    // Space Complexity: O(1)  — in-place modification of the input matrix
    // -------------------------------------------------------------------------

    public void floydWarshall(int[][] dist) {
        int n = dist.length;

        // Try every vertex k as an intermediate node
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Only relax if neither path through k is infinity
                    if (dist[i][k] != (int) 1e8 && dist[k][j] != (int) 1e8) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }
}

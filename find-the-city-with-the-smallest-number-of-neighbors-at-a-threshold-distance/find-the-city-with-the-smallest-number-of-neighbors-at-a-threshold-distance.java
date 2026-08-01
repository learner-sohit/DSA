import java.util.Arrays;

/**
 * 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 *
 * Given n cities and weighted bidirectional edges, and a distanceThreshold,
 * find the city with the smallest number of cities that are reachable through
 * some path and whose distance is at most distanceThreshold.
 * If there are multiple such cities, return the city with the greatest number.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: Floyd-Warshall Algorithm (All-Pairs Shortest Path)
    // Time Complexity:  O(N³) — three nested loops for all-pairs shortest paths
    // Space Complexity: O(N²) — 2D matrix for distance grid
    // -------------------------------------------------------------------------

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j],
                                              dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int city = -1;
        int cntCity = n + 1;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    cnt++;
                }
            }

            if (cnt <= cntCity) {
                cntCity = cnt;
                city = i;
            }
        }

        return city;
    }
}

import java.util.Arrays;

// ===== Approach: Top-Down Dynamic Programming (Memoization) =====
// Time Complexity: O(n) | Space Complexity: O(n)
class Solution {
    public int minCost(int[] height) {
        int n = height.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n - 1, height, dp);
    }

    private int solve(int n, int[] height, int[] dp) {
        if (n == 0)
            return 0;

        if (dp[n] != -1)
            return dp[n];

        int n2 = Integer.MAX_VALUE;
        if (n > 1) {
            n2 = solve(n - 2, height, dp) + Math.abs(height[n] - height[n - 2]);
        }
        int n1 = solve(n - 1, height, dp) + Math.abs(height[n] - height[n - 1]);

        return dp[n] = Math.min(n1, n2);
    }
}

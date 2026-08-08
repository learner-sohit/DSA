// ===== Approach 2: Optimal — Iterative Bottom-Up (Space Optimized) =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int prev2 = 1;
        int prev1 = 2;

        for (int i = 3; i <= n; i++) {
            int curr = prev2 + prev1;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}

/*
// ===== Approach 1: Top-Down Dynamic Programming (Memoization) =====
// Time Complexity: O(n) | Space Complexity: O(n)
import java.util.Arrays;

class Solution {
    private int solve(int n, int[] dp) {
        if (n <= 2) return n;

        if (dp[n] != -1) return dp[n];

        return dp[n] = solve(n - 2, dp) + solve(n - 1, dp);
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }
}
*/

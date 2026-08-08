import java.util.Arrays;

class Solution {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, dp);

        // Recursive brute force:
        // if (n <= 1)
        //     return n;
        // return fib(n - 2) + fib(n - 1);
    }

    private int solve(int n, int[] dp) {
        if (n <= 1)
            return n;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = solve(n - 2, dp) + solve(n - 1, dp);
    }
}

// Iterative bottom-up approach:
// class Solution {
//     public int fib(int n) {
//         if (n <= 1) return n;
//
//         int prev2 = 0, prev1 = 1;
//         for (int i = 2; i <= n; i++) {
//             int curr = prev1 + prev2;
//             prev2 = prev1;
//             prev1 = curr;
//         }
//         return prev1;
//     }
// }

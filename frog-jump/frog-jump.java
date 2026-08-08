// ===== Space-Optimized Dynamic Programming =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
	int minCost(int[] height) {
		int n = height.length;
		int prev1 = 0;
		int prev2 = 0;
		
		for (int i = 1; i<n; i++) {
			int fs = prev1 + Math.abs(height[i] - height[i - 1]);
			
			int ss = Integer.MAX_VALUE;
			if (i > 1)
				ss = prev2 + Math.abs(height[i] - height[i - 2]);
			
			int curr = Math.min(fs, ss);
			prev2 = prev1;
			prev1 = curr;
		}
		
		return prev1;
	}
}

/*
// =====Tabulation=====//
class Solution {
	int minCost(int[] height) {
		int n = height.length;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		
		for (int i = 1; i<n; i++) {
			int fs = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
			
			int ss = Integer.MAX_VALUE;
			if (i > 1)
				ss = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
			
			dp[i] = Math.min(fs, ss);
		}
		
		return dp[n - 1];
	}
}
*/

/*
// =====Memoisation=====//
class Solution {
	int minCost(int[] height) {
		// code here
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
		if (n>1) {
			n2 = solve(n - 2, height, dp) + Math.abs(height[n] - height[n - 2]);
		}
		int n1 = solve(n - 1, height, dp) + Math.abs(height[n] - height[n - 1]);
		
		return dp[n] = Math.min(n1, n2);
	}
}
*/

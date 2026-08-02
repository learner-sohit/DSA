/**
 * Maximum Pair Strength
 *
 * Given an array of integers nums, find the maximum strength among all possible
 * pairs (i, j) where i != j.
 * The strength of a pair (nums[i], nums[j]) is defined as:
 *     (nums[i] * nums[j]) / (gcd(nums[i], nums[j]) ^ 2)
 */

class Solution {

    // Helper method to compute Greatest Common Divisor (GCD) using Euclidean Algorithm
    private static int gcd(int a, int b) {
        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    // -------------------------------------------------------------------------
    // Approach: Brute Force Pairwise Comparison
    // Time Complexity:  O(N² × log(min(A, B))) — iterating all pairs (i, j) and computing GCD
    // Space Complexity: O(1)                   — constant extra space
    // -------------------------------------------------------------------------

    public long maxPairStrength(int[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long hcf = gcd(nums[i], nums[j]);
                long strength = (1L * nums[i] * nums[j]) / (hcf * hcf);
                ans = Math.max(ans, strength);
            }
        }
        return ans;
    }
}

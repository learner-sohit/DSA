/**
 * Count Subarrays With Even and Odd Ratio
 *
 * Given an integer array nums and two integers a and b, return the number of
 * contiguous subarrays where the ratio of even elements (x) to odd elements (y)
 * satisfies x / y <= a / b (or even * b <= odd * a), with at least one odd element (y > 0).
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach: Nested Loop Subarray Traversal
    // Time Complexity:  O(N²) — evaluating all contiguous subarrays (i, j)
    // Space Complexity: O(1)  — constant auxiliary space
    // -------------------------------------------------------------------------

    public int countRatioSubarrays(int[] nums, int a, int b) {
        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int even = 0;
            int odd = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }

                if (odd > 0 && even * b <= odd * a) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

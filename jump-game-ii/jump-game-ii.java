// ===== Approach 3: Optimal — Single Pass Greedy =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }
}

/*
// ===== Approach 2: Better — BFS-style Level Jump =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int low = 0;
        int high = 0;

        while (high < nums.length - 1) {
            int farthest = high;

            for (int i = low; i <= high; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            low = high + 1;
            high = farthest;
            jumps++;
        }
        return jumps;
    }
}
*/

/*
// ===== Approach 1: Brute Force — Recursion (Try all jumps) =====
// Time Complexity: O(n^n) | Space Complexity: O(n) — recursion stack
class Solution {
    int min = Integer.MAX_VALUE;

    public int jump(int[] nums) {
        helper(nums, 0, 0);
        return min;
    }

    private void helper(int[] nums, int idx, int count) {
        if (idx >= nums.length - 1) {
            min = Math.min(min, count);
            return;
        }
        if (count >= min) return; // pruning

        for (int i = 1; i <= nums[idx]; i++) {
            helper(nums, i + idx, count + 1);
        }
    }
}
*/

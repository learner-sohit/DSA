// ===== Approach 2: Optimal — Greedy (Track Max Reachable Index) =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public boolean canJump(int[] nums) {
        int maxIdx = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (i > maxIdx) return false; // current index is unreachable
            maxIdx = Math.max(maxIdx, i + nums[i]);
        }
        return true;
    }
}

/*
// ===== Approach 1: Brute Force — Recursion (Try all jumps) =====
// Time Complexity: O(n^n) | Space Complexity: O(n) — recursion stack
class Solution {
    public boolean canJump(int[] nums) {
        return helper(nums, 0);
    }

    private boolean helper(int[] nums, int idx) {
        if (idx >= nums.length - 1) return true;

        for (int i = 1; i <= nums[idx]; i++) {
            if (helper(nums, i + idx)) return true;
        }
        return false;
    }
}
*/

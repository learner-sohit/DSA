import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 3731. Find Missing Elements
 * Platform: LeetCode
 * Link: https://leetcode.com/problems/find-missing-elements/
 */
class Solution {

    // Brute force: scan every value from the range and search for it in nums.
    // Time Complexity: O(N * R); Space Complexity: O(1), excluding the result.
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for (int value = min; value <= max; value++) {
            boolean found = false;

            for (int num : nums) {
                if (num == value) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                ans.add(value);
            }
        }

        return ans;
    }

    /*
    // Optimal: use a HashSet for constant-time membership checks.
    // Time Complexity: O(N + R); Space Complexity: O(N).
    public List<Integer> findMissingElementsOptimal(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }

        for (int value = min + 1; value < max; value++) {
            if (!set.contains(value)) {
                ans.add(value);
            }
        }

        return ans;
    }
    */
}

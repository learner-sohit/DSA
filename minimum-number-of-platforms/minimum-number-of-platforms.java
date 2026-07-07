import java.util.Arrays;

// ===== Approach 1: Greedy — Sort Arrivals & Departures + Two Pointers =====
// Time Complexity: O(n log n) | Space Complexity: O(1)
class Solution {
    public int minPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int n = arr.length;
        int i = 1, j = 0, count = 1, maxCount = 1;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                // New train arrives before the earliest departure → need extra platform
                count++;
                i++;
            } else {
                // A train departs before the next arrival → free up a platform
                count--;
                j++;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}

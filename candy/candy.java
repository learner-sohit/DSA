// ===== Approach 3: Optimal — Single Pass (Slope counting) =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1) return 1;

        int sum = 1;
        int i = 1;

        while (i < n) {
            // Equal ratings: give exactly 1 candy
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }

            // Count the ascending slope (up-hill)
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak += 1;
                sum += peak;
                i++;
            }

            // Count the descending slope (down-hill)
            int down = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                sum += down;
                down += 1;
                i++;
            }

            // If the descending slope is longer than the ascending peak,
            // the peak child needs extra candies to stay above the down-slope
            if (down > peak) {
                sum += (down - peak);
            }
        }
        return sum;
    }
}

/*
// ===== Approach 2: Better — Two Arrays Optimized (O(1) extra space right pass) =====
// Time Complexity: O(n) | Space Complexity: O(n) — only left array kept
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] left = new int[n];
        left[0] = 1;

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int curr = 1, right = 1;
        int sum = Math.max(left[n - 1], 1);

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                curr = right + 1;
            } else {
                curr = 1;
            }
            right = curr;
            sum += Math.max(left[i], curr);
        }

        return sum;
    }
}
*/

/*
// ===== Approach 1: Brute Force — Two Full Arrays (left[] and right[]) =====
// Time Complexity: O(n) | Space Complexity: O(n)
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        int maxCandies = 0;
        for (int i = 0; i < n; i++) {
            maxCandies += Math.max(left[i], right[i]);
        }

        return maxCandies;
    }
}
*/

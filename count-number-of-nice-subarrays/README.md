# 1248. Count Number of Nice Subarrays

[Link to Problem on LeetCode](https://leetcode.com/problems/count-number-of-nice-subarrays/)

## Problem Description

Given an array of integers `nums` and an integer `k`, a "nice" subarray is a continuous subarray that has exactly `k` odd numbers within it.

Return *the number of "nice" subarrays*.

### Example

**Input:** `nums = [1,1,2,1,1]`, `k = 3`
**Output:** `2`
**Explanation:** The subarrays `[1,1,2,1]` and `[1,2,1,1]` have exactly 3 odd numbers.

## Explanation

The solution file contains implementations for both a brute-force and an optimal approach.

### Brute-Force Approach

This method checks every possible subarray to see if it contains exactly `k` odd numbers.

1.  Iterate through the array with an outer loop (`i`) to define the start of a subarray.
2.  For each start, use an inner loop (`j`) to expand the subarray to the right.
3.  Keep a count of the odd numbers in the current subarray (`oddCount`).
4.  If `oddCount` equals `k`, we've found a "nice" subarray, so increment the main `count`.
5.  If `oddCount` exceeds `k`, we can break the inner loop, as any further expansion of this subarray will also have more than `k` odd numbers.

-   **Time Complexity:** O(n²)
-   **Space Complexity:** O(1)

### Optimal Approach (Sliding Window)

This problem is very similar to "Binary Subarrays With Sum" and can be solved with the same clever sliding window technique. The core idea is to transform the problem from finding subarrays with *exactly* `k` odd numbers to finding subarrays with *at most* `k` odd numbers.

The logic is: `count(exactly k) = count(at most k) - count(at most k - 1)`.

1.  A helper function, `countSubArray(nums, k)`, is created to count the number of subarrays with at most `k` odd numbers.
2.  Inside the helper function, a standard sliding window is used:
    -   Expand the window by moving `right` and increment `oddCount` if `nums[right]` is odd.
    -   If `oddCount > k`, shrink the window from the `left` until the `oddCount` is valid again.
    -   For each valid window (from `left` to `right`), the number of new subarrays ending at `right` is `right - left + 1`. Add this to the total `count`.
3.  The main function then calls `countSubArray(nums, k)` and subtracts the result of `countSubArray(nums, k - 1)` to get the final answer.

-   **Time Complexity:** O(n)
-   **Space Complexity:** O(1)

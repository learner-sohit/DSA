# 1004. Max Consecutive Ones III

[Link to Problem on LeetCode](https://leetcode.com/problems/max-consecutive-ones-iii/)

## Problem Description

Given a binary array `nums` and an integer `k`, return the maximum number of consecutive `1`'s in the array if you can flip at most `k` `0`'s.

### Example

**Input:** `nums = [1,1,1,0,0,0,1,1,1,1,0]`, `k = 2`
**Output:** `6`
**Explanation:** `[1,1,1,0,0,**1**,1,1,1,1,**1**]`
Flip the two zeros to get the longest possible subarray of ones. The length is 6.

## Explanation

The solution file contains implementations for both a brute-force and an optimal approach.

### Brute-Force Approach

This method checks every possible subarray to see if it can be made valid by flipping at most `k` zeros.

1.  Iterate through the array with an outer loop (`i`) to define the start of a potential subarray.
2.  For each start, use an inner loop (`j`) to expand the subarray to the right.
3.  Keep a count of the number of zeros encountered in the current subarray (`i` to `j`).
4.  If the zero count exceeds `k`, this subarray is invalid, so we break the inner loop.
5.  If the zero count is within the limit, the current subarray is valid. Calculate its length (`j - i + 1`) and update the `maxlen` if it's the longest one found so far.

-   **Time Complexity:** O(n²)
-   **Space Complexity:** O(1)

### Optimal Approach (Sliding Window)

This method uses a sliding window to find the longest subarray with at most `k` zeros in a single pass.

1.  Initialize two pointers, `left` and `right`, to `0`. Also, initialize `zeros` to `0` to count zeros in the current window and `maxlen` to `0`.
2.  Expand the window by moving the `right` pointer. If `nums[right]` is a `0`, increment the `zeros` count.
3.  If the number of `zeros` in the window exceeds `k`, the window is invalid. We must shrink it from the left by moving the `left` pointer.
    -   If the element at `nums[left]` was a `0`, decrement the `zeros` count as it's no longer in the window.
    -   Increment `left`.
4.  After each adjustment, the window from `left` to `right` is a valid one. Calculate its length (`right - left + 1`) and update `maxlen`.
5.  Continue until the `right` pointer reaches the end of the array.

-   **Time Complexity:** O(n)
-   **Space Complexity:** O(1)

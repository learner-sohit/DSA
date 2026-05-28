# 930. Binary Subarrays With Sum

[Link to Problem on LeetCode](https://leetcode.com/problems/binary-subarrays-with-sum/)

## Problem Description

Given a binary array `nums` and an integer `goal`, return the number of non-empty subarrays with a sum `goal`.

A subarray is a contiguous part of the array.

### Example

**Input:** `nums = [1,0,1,0,1]`, `goal = 2`
**Output:** `4`
**Explanation:** The 4 subarrays are `[1,0,1]`, `[1,0,1,0]`, `[0,1,0,1]`, and `[1,0,1]`.

## Explanation

The solution file contains implementations for both a brute-force and an optimal approach.

### Brute-Force Approach

This method checks every possible subarray to see if its sum equals the `goal`.

1.  Iterate through the array with an outer loop (`i`) to define the start of a subarray.
2.  For each start, use an inner loop (`j`) to expand the subarray to the right, calculating the `sum` along the way.
3.  If the `sum` equals the `goal`, increment a counter.
4.  If the `sum` exceeds the `goal`, we can break the inner loop since all further subarrays starting at `i` will also exceed the goal (as numbers are non-negative).

- **Time Complexity:** O(n²)
- **Space Complexity:** O(1)

### Optimal Approach (Sliding Window)

This is a clever approach that uses a sliding window to solve the problem in linear time. The core idea is to transform the problem from finding subarrays with a sum _exactly_ equal to `goal` to finding subarrays with a sum _at most_ `goal`.

The logic is: `count(exactly goal) = count(at most goal) - count(at most goal - 1)`.

1.  A helper function, `countSubArray(nums, goal)`, is created to count the number of subarrays with a sum less than or equal to `goal`.
2.  Inside the helper function, a standard sliding window is used:
    - Initialize `left`, `right`, `sum`, and `count`.
    - Expand the window by moving `right` and adding `nums[right]` to `sum`.
    - If `sum > goal`, shrink the window from the `left` until the `sum` is valid again.
    - For each valid window (from `left` to `right`), the number of new subarrays ending at `right` is `right - left + 1`. Add this to `count`.
3.  The main function then calls `countSubArray(nums, goal)` and subtracts the result of `countSubArray(nums, goal - 1)` to get the final answer.

- **Time Complexity:** O(n) - The array is traversed a constant number of times.
- **Space Complexity:** O(1)

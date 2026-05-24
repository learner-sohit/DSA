# 485. Max Consecutive Ones

[Link to Problem on LeetCode](https://leetcode.com/problems/max-consecutive-ones/)

## Problem Description

Given a binary array `nums`, return the maximum number of consecutive `1`s in the array.

### Example

**Input:** `nums = [1,1,0,1,1,1]`
**Output:** `3`
**Explanation:** The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

## Explanation

### Approach

The solution uses a simple and efficient single-pass approach to find the maximum number of consecutive ones.

The algorithm works as follows:

1.  Initialize two variables: `max` to store the maximum consecutive count found so far, and `len` to store the current consecutive count. Both are set to `0`.
2.  Iterate through the input array `nums` from left to right.
3.  For each number:
    -   If the number is `0`, it breaks the sequence of ones. Reset the current count `len` to `0`.
    -   If the number is `1`, increment the current count `len`.
4.  After incrementing `len`, compare it with `max` and update `max` if `len` is greater.
5.  After the loop finishes, `max` will hold the highest count of consecutive ones found in the array.

### Complexity

-   **Time Complexity:** O(n) - We iterate through the array exactly once.
-   **Space Complexity:** O(1) - We only use a constant amount of extra space for the `max` and `len` variables.

# 1358. Number of Substrings Containing All Three Characters

[Link to Problem on LeetCode](https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/)

## Problem Description

Given a string `s` consisting only of characters `'a'`, `'b'`, and `'c'`, return _the number of substrings that contain at least one of each of these characters in it_.

### Example

**Input:** `s = "abcabc"`
**Output:** `10`
**Explanation:** The substrings containing at least one of 'a', 'b', and 'c' are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).

## Explanation

The solution file contains implementations for both a brute-force and an optimal approach.

### Brute-Force Approach

This method checks every possible substring to see if it contains all three characters ('a', 'b', 'c').

1.  Iterate through the string with an outer loop (`i`) to define the start of a substring.
2.  For each start, use an inner loop (`j`) to expand the subarray to the right.
3.  Use a `Set` to keep track of the distinct characters in the current substring.
4.  If the `set.size` becomes `3`, it means the current substring is valid. Increment the `count`.
5.  Unlike previous problems, we don't break here. Any further expansion of this valid substring (e.g., from "abc" to "abca") will also be valid, so we continue the inner loop.

- **Time Complexity:** O(n²)
- **Space Complexity:** O(1) - The set will hold at most 3 characters.

### Optimal Approach (Sliding Window)

A more efficient approach uses a sliding window. The key insight is that once we find a valid window (a substring from `left` to `right` that contains 'a', 'b', and 'c'), we know that any substring that _starts_ at `left` and _ends_ at or after `right` will also be valid.

1.  Initialize `left` and `right` pointers, and a `count` for the result. Use a map or an array to track the last seen index of 'a', 'b', and 'c'.
2.  Expand the window by moving the `right` pointer.
3.  When the window from `left` to `right` contains all three characters:
    - We have found a valid substring. The number of valid substrings that _end_ at or after `right` but _start_ at `left` is `s.length - right`. Add this to the total `count`.
    - Now, we can shrink the window from the `left` by incrementing the `left` pointer. This is because we've already counted all valid substrings starting at the old `left` position.
4.  Continue this process until `right` reaches the end of the string.

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

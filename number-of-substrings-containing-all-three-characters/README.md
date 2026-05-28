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

### Optimal Approach (Sliding Window with Last Seen Indices)

A highly efficient approach uses a single pass through the string, keeping track of the last seen index of each character ('a', 'b', 'c').

The core idea is that for any character at index `i`, if we have seen all three characters, we can form new valid substrings. A substring is valid if it contains at least one 'a', 'b', and 'c'.

1.  Initialize an array `lastSeen` to `[-1, -1, -1]` to store the last index where 'a', 'b', and 'c' were found.
2.  Initialize `count` to `0`.
3.  Iterate through the string with a single pointer `i`.
4.  In each iteration, update the `lastSeen` index for the character `s[i]`.
5.  After updating, check if all three characters have been seen (i.e., none of the values in `lastSeen` are -1).
6.  If they have, it means we can form new valid substrings. The number of valid substrings that **end** at the current index `i` is determined by the earliest-seen character among the three. If the minimum index in `lastSeen` is, for example, `min_index`, then any substring starting from index `0` up to `min_index` and ending at `i` will be valid. The number of such substrings is `1 + min_index`. We add this to our total `count`.
7.  Continue until the loop finishes, and `count` will hold the total number of valid substrings.

-   **Time Complexity:** O(n) - We iterate through the string only once.
-   **Space Complexity:** O(1) - The `lastSeen` array is of constant size.

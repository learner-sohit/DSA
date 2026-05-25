# 424. Longest Repeating Character Replacement

[Link to Problem on LeetCode](https://leetcode.com/problems/longest-repeating-character-replacement/)

## Problem Description

You are given a string `s` and an integer `k`. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most `k` times.

Return *the length of the longest substring containing the same letter you can get after performing the above operations*.

## Explanation

The solution file contains implementations for a brute-force and two optimal sliding window approaches.

### Brute-Force Approach

This method checks every possible subarray to see if it can be made valid by flipping at most `k` characters.

-   **Time Complexity:** O(n²)
-   **Space Complexity:** O(1) - The hash array is of constant size 26.

### Optimal Approach 1 (Sliding Window with Map)

This method uses a sliding window to find the longest valid substring in a single pass.

1.  Use two pointers, `left` and `right`, and a `Map` to store the frequency of characters in the current window.
2.  Expand the window by moving `right`. Keep track of the frequency of the most common character (`freq`).
3.  The number of characters we need to change is `window_length - freq`.
4.  If `changes > k`, the window is invalid. Shrink it from the `left`, updating the map accordingly.
5.  After each step, the window is valid. Update `maxlen`.

-   **Time Complexity:** O(n)
-   **Space Complexity:** O(k) - Where k is the number of unique characters.

### Optimal Approach 2 (More Optimized Sliding Window)

This is a more refined version of the sliding window. The key insight is that we don't need to find the absolute `maxFreq` in every window. We only care if a new, larger window is possible, which only happens if `maxFreq` increases.

1.  Use a fixed-size array (`freq`) for character counts, which is slightly faster than a map for this problem.
2.  Expand the window by moving `right`.
3.  Update `maxFreq` but **never decrease it**. This is the clever part. The window size will only grow when we find a new `maxFreq` that allows for a larger valid window. If `maxFreq` is stale (i.e., the character that had the max frequency is no longer the most frequent in the current, smaller window), our condition `(right - left + 1) - maxFreq > k` will still correctly trigger a window shrink. The window size `(right - left + 1)` will not exceed the true `maxlen` until we find a new, larger `maxFreq`.
4.  If the window is invalid (`changes > k`), shrink it from the `left`.
5.  The length of the window `(right - left + 1)` is always a candidate for the max length.

-   **Time Complexity:** O(n)
-   **Space Complexity:** O(1) - The frequency array is constant size.

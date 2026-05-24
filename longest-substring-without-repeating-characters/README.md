# 3. Longest Substring Without Repeating Characters

[Link to Problem on LeetCode](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

## Problem Description

Given a string `s`, the task is to find the length of the **longest substring** without repeating characters. A substring is a contiguous non-empty sequence of characters within a string.

For example:

- If `s = "abcabcbb"`, the answer is `3` because the longest substring without repeating characters is `"abc"`.
- If `s = "bbbbb"`, the answer is `1` because the longest substring is `"b"`.
- If `s = "pwwkew"`, the answer is `3` because the longest substring is `"wke"`. Note that `"pwke"` is a subsequence and not a substring.

## Explanation

The solution file contains implementations for both the brute-force and optimal approaches, named `lengthOfLongestSubstring_bruteForce` and `lengthOfLongestSubstring` respectively.

### Brute-Force Approach

The provided solution uses a brute-force approach to solve this problem. The main idea is to generate all possible substrings, check if each substring has repeating characters, and keep track of the maximum length found so far.

The algorithm works as follows:

1.  Initialize `maxLen` to `0` to store the length of the longest substring found.
2.  Iterate through the string with an outer loop, using `i` as the starting index of the substring.
3.  For each starting index `i`, start an inner loop with index `j` from `i` to the end of the string. This loop generates all substrings starting at `i`.
4.  Inside the inner loop, use a hash map (in this case, an array `hash`) to keep track of the characters in the current substring (from `i` to `j`).
5.  If the character `s[j]` is already in the `hash`, it means we have found a repeating character. We break the inner loop and move to the next starting index `i`.
6.  If `s[j]` is not in the `hash`, we add it and update `maxLen` with the length of the current valid substring (`j - i + 1`).
7.  After checking all substrings, `maxLen` will hold the length of the longest substring without repeating characters.

### Complexity

- **Time Complexity:** O(n²) - The nested loops iterate through all possible substrings, leading to a quadratic time complexity.
- **Space Complexity:** O(k) - Where `k` is the number of unique characters in the character set. In the worst case, this can be O(n) if all characters in the substring are unique.

### Optimal Approach (Sliding Window)

The optimal solution uses the **sliding window** technique with a hash map to solve the problem in linear time. A "window" is a conceptual range over the string, defined by a `left` and a `right` pointer. The goal is to expand the window from the right and shrink it from the left as needed to maintain a substring with no repeating characters.

The algorithm works as follows:

1.  Initialize `maxLen` to `0`, and set two pointers, `left` and `right`, to `0`.
2.  Create a `Map` to store the most recent index of each character encountered.
3.  Iterate through the string by moving the `right` pointer from the beginning to the end.
4.  At each step, check if the character `s[right]` is already in the map and if its last seen index is within the current window (i.e., `map.get(s[right]) >= left`).
    - If it is, a repeating character is found inside the current window. To fix this, move the `left` pointer to the position right after the last occurrence of the repeating character (`map.get(s[right]) + 1`). This effectively shrinks the window to exclude the repeated character.
5.  Update the map with the current character's index: `map.set(s[right], right)`.
6.  Calculate the length of the current window (`right - left + 1`) and update `maxLen` if the current window is larger.
7.  Increment the `right` pointer to expand the window.
8.  After the loop finishes, `maxLen` will hold the length of the longest valid substring.

### Complexity

- **Time Complexity:** O(n) - Each character in the string is visited by the `left` and `right` pointers at most once.
- **Space Complexity:** O(k) - Where `k` is the number of unique characters in the character set. In the worst case, this is O(n) if all characters in the string are unique.

# 904. Fruit Into Baskets

[Link to Problem on LeetCode](https://leetcode.com/problems/fruit-into-baskets/)

## Problem Description

You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array `fruits` where `fruits[i]` is the type of fruit the `i`-th tree produces.

You want to collect as much fruit as possible, but the owner has some strict rules:

1.  You only have **two baskets**, and each basket can only hold a **single type** of fruit. There is no limit on the amount of fruit each basket can hold.
2.  Starting from any tree of your choice, you must pick **exactly one fruit** from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your two baskets.
3.  Once you reach a tree with fruit that cannot fit in your baskets, you must stop.

Given the integer array `fruits`, return _the **maximum** number of fruits you can pick_.

This problem is equivalent to finding the **longest subarray with at most two distinct elements**.

## Explanation

The solution file contains implementations for both a brute-force and an optimal approach.

### Brute-Force Approach

This method checks every possible subarray to find the longest one that contains at most two distinct fruit types.

1.  Iterate through the array with an outer loop (`i`) to define the start of a potential subarray.
2.  For each start, use an inner loop (`j`) to expand the subarray to the right.
3.  Use a `Set` to keep track of the distinct fruit types in the current subarray (`i` to `j`).
4.  If the size of the `Set` is less than or equal to 2, the subarray is valid. Calculate its length (`j - i + 1`) and update `max` if it's the longest found so far.
5.  If the `Set` size becomes greater than 2, it means we've encountered a third type of fruit, so we break the inner loop and move to the next starting position.

- **Time Complexity:** O(n²)
- **Space Complexity:** O(1) - The set will hold at most 3 elements.

### Optimal Approach (Sliding Window)

This method uses a sliding window to find the longest subarray with at most two distinct elements in a single pass.

1.  Initialize two pointers, `left` and `right`, to `0`, and `maxlen` to `0`.
2.  Use a `Map` to store the count of each fruit type within the current window.
3.  Expand the window by moving the `right` pointer and update the count of `fruits[right]` in the map.
4.  If the `map.size` becomes greater than 2, the window is invalid. We must shrink it from the left:
    - Decrement the count of the fruit at the `left` pointer.
    - If the count of that fruit becomes `0`, remove it from the map entirely.
    - Increment `left`.
5.  After each adjustment, the window from `left` to `right` is valid. Calculate its length (`right - left + 1`) and update `maxlen`.
6.  Continue until the `right` pointer reaches the end of the array.

- **Time Complexity:** O(n)
- **Space Complexity:** O(1) - The map will hold at most 3 distinct fruit types.

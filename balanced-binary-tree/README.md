# 110. Balanced Binary Tree

[Link to Problem on LeetCode](https://leetcode.com/problems/balanced-binary-tree/)

## Problem Description

Given a binary tree, determine whether it is height-balanced.

A height-balanced binary tree is a tree in which the heights of the left and right subtrees of every node differ by no more than `1`.

### Example

**Input:** `root = [3,9,20,null,null,15,7]`  
**Output:** `true`

## Explanation

The solution file contains both brute-force and optimal recursive approaches.

### Optimal Bottom-Up DFS

The optimal solution calculates each subtree's height while checking whether it is balanced.

1. Return `0` when the current node is `null`.
2. Recursively calculate the left subtree height.
3. If the left subtree returns `-1`, immediately propagate `-1`.
4. Recursively calculate the right subtree height.
5. If the right subtree returns `-1`, immediately propagate `-1`.
6. If the two heights differ by more than `1`, return `-1` to mark the subtree as unbalanced.
7. Otherwise, return the current subtree height.

The public method returns `true` when the DFS result is not `-1`.

- **Time Complexity:** O(N), because every node is visited once.
- **Space Complexity:** O(H), where H is the tree height, for the recursive call stack.

### Brute-Force Recursive Approach

For every node, the brute-force solution separately calculates the heights of its left and right subtrees. It then recursively checks whether both subtrees are balanced.

This repeatedly recalculates the heights of the same subtrees.

- **Time Complexity:** O(N²) in the worst case for a skewed tree.
- **Space Complexity:** O(H) for the recursive call stack.

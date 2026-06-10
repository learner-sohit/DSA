# 543. Diameter of Binary Tree

[Link to Problem on LeetCode](https://leetcode.com/problems/diameter-of-binary-tree/)

## Problem Description

Given the `root` of a binary tree, return the length of its diameter.

The diameter is the length of the longest path between any two nodes in the tree. The path may or may not pass through the root, and its length is measured by the number of edges.

### Example

**Input:** `root = [1,2,3,4,5]`  
**Output:** `3`

**Explanation:** One longest path is `[4,2,1,3]`, which contains three edges.

## Explanation

The solution file contains optimal and brute-force recursive approaches.

### Optimal Depth-First Search

The optimal solution calculates subtree heights and updates the maximum diameter during the same traversal.

1. Return height `0` for a null node.
2. Recursively calculate the left and right subtree heights.
3. The diameter passing through the current node is `leftHeight + rightHeight`.
4. Update `maxDiameter` if this diameter is larger than the previous maximum.
5. Return the current node's height as `1 + max(leftHeight, rightHeight)`.

- **Time Complexity:** O(N), because every node is visited once.
- **Space Complexity:** O(H), where H is the tree height, for the recursive call stack.

### Brute-Force Recursive Approach

The brute-force solution calculates the diameter passing through the current node, then recursively finds the largest diameter in the left and right subtrees.

Because subtree heights are recalculated for many nodes, this approach performs repeated work.

- **Time Complexity:** O(N²) in the worst case for a skewed tree.
- **Space Complexity:** O(H) for the recursive call stack.

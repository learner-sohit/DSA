# 101. Symmetric Tree

[Link to Problem on LeetCode](https://leetcode.com/problems/symmetric-tree/)

## Problem Description

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

### Example

**Input:** `root = [1,2,2,3,4,4,3]`  
**Output:** `true`

**Input:** `root = [1,2,2,null,3,null,3]`  
**Output:** `false`

## Explanation

### Optimal Recursive DFS

The optimal solution checks whether the left and right subtrees are mirror images of each other using depth-first search.

1. If both nodes are `null`, the subtrees match.
2. If only one node is `null`, the tree is not symmetric.
3. If the node values differ, the tree is not symmetric.
4. Otherwise, recursively compare the left child of the first node with the right child of the second node, and the right child of the first node with the left child of the second node.

- **Time Complexity:** O(N), where N is the number of nodes in the tree.
- **Space Complexity:** O(H), where H is the tree height, for the recursive call stack.

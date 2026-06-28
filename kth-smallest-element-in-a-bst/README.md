# 230. Kth Smallest Element in a BST

[Link to Problem on LeetCode](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)

## Problem Description

Given the `root` of a binary search tree, and an integer `k`, return the `k`th smallest value (1-indexed) of all the values of the nodes in the tree.

### Example

**Input:** `root = [3,1,4,null,2], k = 1`  
**Output:** `1`

**Input:** `root = [5,3,6,2,4,null,null,1], k = 3`  
**Output:** `3`

## Explanation

### Morris Inorder Traversal

The optimal solution performs an inorder traversal of the BST using Morris traversal and stops once the `k`th node is visited.

1. Start from the root with `count = 0`.
2. If the current node has no left child, it is the next inorder node:
   - Increment `count`.
   - Return the value immediately if `count == k`.
   - Move to the right child.
3. Otherwise, find the inorder predecessor in the left subtree.
4. If no temporary thread exists, create one and move left.
5. If a thread already exists, remove it, visit the current node, increment `count`, return if `count == k`, then move right.
6. Return `-1` if the traversal finishes without finding the target.

Because inorder traversal of a BST visits values in sorted order, the `k`th visited node is the answer.

- **Time Complexity:** O(N), where N is the number of nodes in the tree.
- **Space Complexity:** O(1), excluding the tree itself, because Morris traversal uses threading instead of a stack.

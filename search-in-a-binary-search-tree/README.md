# 700. Search in a Binary Search Tree

[Link to Problem on LeetCode](https://leetcode.com/problems/search-in-a-binary-search-tree/)

## Problem Description

You are given the root of a binary search tree (BST) and an integer `val`.

Find the node in the BST that the node's value equals `val` and return the subtree rooted with that node. If such a node does not exist, return `null`.

### Example

**Input:** `root = [4,2,7,1,3], val = 2`  
**Output:** `[2,1,3]`

**Input:** `root = [4,2,7,1,3], val = 5`  
**Output:** `[]`

## Explanation

The solution file contains recursive and iterative approaches.

### Recursive DFS

The recursive solution uses the BST property to decide which subtree to explore.

1. If the current node is `null`, the value is not present.
2. If the current node's value equals `val`, return that node.
3. If `val` is greater than the current value, search the right subtree.
4. Otherwise, search the left subtree.

- **Time Complexity:** O(H), where H is the height of the tree.
- **Space Complexity:** O(H), for the recursive call stack.

### Iterative Approach

The iterative solution follows the same BST logic using a loop instead of recursion.

1. While the current node is not `null`, compare its value with `val`.
2. Return the node immediately when a match is found.
3. Move to the right child if `val` is greater, otherwise move to the left child.
4. Return `null` if the loop ends without finding the target.

- **Time Complexity:** O(H).
- **Space Complexity:** O(1).

# 199. Binary Tree Right Side View

[Link to Problem on LeetCode](https://leetcode.com/problems/binary-tree-right-side-view/)

## Problem Description

Given the `root` of a binary tree, imagine yourself standing on the **right side** of it, return the values of the nodes you can see ordered from top to bottom.

### Example

**Input:** `root = [1,2,3,null,5,null,4]`  
**Output:** `[1,3,4]`

**Input:** `root = [1,null,3]`  
**Output:** `[1,3]`

## Explanation

### Optimal Recursive DFS

The optimal solution performs a depth-first traversal while visiting the right subtree before the left subtree at each node.

1. Maintain a result list where index `level` stores the rightmost visible node at that depth.
2. At each node, if `level == result.size()`, this is the first node seen at that depth from the right side, so add its value.
3. Recurse on the right child first, then the left child, both at `level + 1`.
4. Return the result list after traversing the entire tree.

Visiting the right subtree first ensures the rightmost node at each level is recorded before any node to its left.

- **Time Complexity:** O(N), where N is the number of nodes in the tree.
- **Space Complexity:** O(H), where H is the tree height, for the recursive call stack.

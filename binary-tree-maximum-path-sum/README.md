# 124. Binary Tree Maximum Path Sum

[Link to Problem on LeetCode](https://leetcode.com/problems/binary-tree-maximum-path-sum/)

## Problem Description

Given the `root` of a non-empty binary tree, return the maximum path sum of any non-empty path.

A path is a sequence of connected nodes in which each pair of adjacent nodes has an edge between them. A node can appear at most once in a path, and the path does not need to pass through the root.

### Example

**Input:** `root = [-10,9,20,null,null,15,7]`  
**Output:** `42`

**Explanation:** The optimal path is `[15,20,7]`, with a path sum of `15 + 20 + 7 = 42`.

## Explanation

The solution file contains optimal and brute-force recursive approaches.

### Optimal Depth-First Search

The optimal solution calculates the maximum downward gain from each node while updating the best complete path during the same traversal.

1. Recursively calculate the maximum gain from the left and right subtrees.
2. Ignore a negative subtree gain by replacing it with `0`.
3. Treat `node.val + leftGain + rightGain` as the best path passing through the current node.
4. Update the global maximum path sum.
5. Return `node.val + max(leftGain, rightGain)` because a path passed to the parent cannot branch in both directions.

- **Time Complexity:** O(N), because every node is visited once.
- **Space Complexity:** O(H), where H is the tree height, for the recursive call stack.

### Brute-Force Recursive Approach

The brute-force solution considers every node as the highest point of a possible path. For each node, it separately calculates the maximum downward gain from its left and right children.

Because these downward gains are recalculated for many nodes, the approach performs repeated work.

- **Time Complexity:** O(N²) in the worst case for a skewed tree.
- **Space Complexity:** O(H) for the recursive call stack.

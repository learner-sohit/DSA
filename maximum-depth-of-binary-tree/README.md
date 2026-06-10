# 104. Maximum Depth of Binary Tree

[Link to Problem on LeetCode](https://leetcode.com/problems/maximum-depth-of-binary-tree/)

## Problem Description

Given the `root` of a binary tree, return its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

### Example

**Input:** `root = [3,9,20,null,null,15,7]`  
**Output:** `3`

## Explanation

### Recursive Depth-First Search

The solution recursively calculates the maximum depth of the left and right subtrees.

1. If the current node is `null`, return `0` because an empty tree has no depth.
2. Recursively calculate the depth of the left subtree.
3. Recursively calculate the depth of the right subtree.
4. Take the greater of the two subtree depths.
5. Add `1` for the current node and return the result.

The recurrence relation is:

```text
depth(root) = 1 + max(depth(root.left), depth(root.right))
```

- **Time Complexity:** O(N), where N is the number of nodes. Each node is visited once.
- **Space Complexity:** O(H), where H is the height of the tree, for the recursive call stack. In the worst case, this is O(N).

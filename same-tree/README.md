# 100. Same Tree

[Link to Problem on LeetCode](https://leetcode.com/problems/same-tree/)

## Problem Description

Given the roots of two binary trees `p` and `q`, write a function to check whether they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

### Example

**Input:** `p = [1,2,3], q = [1,2,3]`  
**Output:** `true`

**Input:** `p = [1,2], q = [1,null,2]`  
**Output:** `false`

## Explanation

The solution file contains recursive and iterative approaches.

### Optimal Recursive DFS

The optimal solution compares both trees in parallel using depth-first search.

1. If both nodes are `null`, the subtrees match.
2. If only one node is `null`, the trees differ.
3. If the node values differ, the trees differ.
4. Otherwise, recursively compare the left subtrees and the right subtrees.

- **Time Complexity:** O(N), where N is the number of nodes in the smaller tree.
- **Space Complexity:** O(H), where H is the tree height, for the recursive call stack.

### Iterative BFS Approach

The iterative solution uses two queues to traverse both trees level by level.

1. Enqueue the roots of both trees.
2. While both queues are non-empty, dequeue one node from each queue.
3. If both dequeued nodes are `null`, continue to the next pair.
4. If one node is `null` or their values differ, return `false`.
5. Enqueue the left and right children of both nodes.
6. Return `true` only if both queues are empty at the end.

- **Time Complexity:** O(N).
- **Space Complexity:** O(W), where W is the maximum width of the tree.

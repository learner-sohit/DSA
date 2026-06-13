# 103. Binary Tree Zigzag Level Order Traversal

[Link to Problem on LeetCode](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

## Problem Description

Given the `root` of a binary tree, return _the zigzag level order traversal of its nodes' values_. (i.e., from left to right, then right to left for the next level and alternate between).

### Example

**Input:** `root = [3,9,20,null,null,15,7]`  
**Output:** `[[3],[20,9],[15,7]]`

## Explanation

### BFS with a Queue

This solution extends standard level-order traversal with a direction flag that alternates after each level.

1. **Initialization**:
   - If `root` is null, return an empty list.
   - Create a queue and enqueue the root.
   - Set `leftToRight = true` to start the first level from left to right.

2. **Level-by-Level Traversal**:
   - While the queue is not empty, capture `levelSize` for the current level.
   - Create a `currentLevel` list for this level's values.
   - Process exactly `levelSize` nodes:
     - Dequeue a node.
     - If traversing left to right, append `node.val` to the end of `currentLevel`.
     - If traversing right to left, insert `node.val` at index `0` of `currentLevel`.
     - Enqueue the node's left and right children if they exist.
   - Add `currentLevel` to `result`.
   - Flip `leftToRight` before processing the next level.

3. **Return**: Once the queue is empty, return `result`.

- **Time Complexity:** O(N), where N is the number of nodes. Each node is visited once. Inserting at the front of a list can cost O(level width) per node in the worst case, but the total work across a level remains proportional to that level's size.
- **Space Complexity:** O(W), where W is the maximum width of the tree, for the queue and the current level list.

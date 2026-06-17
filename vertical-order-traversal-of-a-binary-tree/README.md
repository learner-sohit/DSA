# 987. Vertical Order Traversal of a Binary Tree

[Link to Problem on LeetCode](https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/)

## Problem Description

Given the `root` of a binary tree, calculate the **vertical order traversal** of the binary tree.

For each node at position `(row, col)`, its left and right children will be at positions `(row + 1, col - 1)` and `(row + 1, col + 1)` respectively. The root of the tree is at `(0, 0)`.

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. If two nodes are in the same row and column, the order should be from left to right.

### Example

**Input:** `root = [3,9,20,null,null,15,7]`  
**Output:** `[[9],[3,15],[20],[7]]`

## Explanation

### BFS with Nested TreeMaps and Priority Queues

This solution assigns each node a `(row, column)` coordinate and groups values by column, then by row, while preserving the required ordering within the same cell.

1. **Initialization**:
   - Use a nested map: `column -> row -> min-heap of node values`.
   - `TreeMap` keeps columns and rows sorted automatically.
   - `PriorityQueue` ensures nodes in the same `(row, column)` appear in ascending value order.
   - Start BFS from `(root, row = 0, column = 0)`.

2. **Traversal**:
   - Dequeue a `(node, row, column)` tuple.
   - Insert `node.val` into the priority queue at `map[column][row]`.
   - Enqueue the left child at `(row + 1, column - 1)`.
   - Enqueue the right child at `(row + 1, column + 1)`.

3. **Build Result**:
   - Iterate columns from left to right using the outer `TreeMap`.
   - For each column, iterate rows top to bottom using the inner `TreeMap`.
   - Poll all values from each row's priority queue into a single column list.
   - Append each column list to `result`.

- **Time Complexity:** O(N log N), where N is the number of nodes. Sorting comes from `TreeMap` operations and priority queue insertions/extractions.
- **Space Complexity:** O(N), for the queue and the nested map storing all node values.

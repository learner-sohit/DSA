# Top View of Binary Tree

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1)

## Problem Description

Given a binary tree, return the nodes visible when the tree is viewed from the top. If multiple nodes share the same horizontal distance, only the topmost node is visible.

### Example

**Input:** `root = [1, 2, 3]`  
**Output:** `[2, 1, 3]`

**Input:** `root = [10, 20, 30, 40, 60, 50, 70]`  
**Output:** `[40, 20, 10, 30, 70]`

## Explanation

### Optimal BFS with TreeMap

This solution assigns each node a column index and uses breadth-first search to record the first node seen at each column.

1. Treat the root as column `0`.
2. Move to the left child at `column - 1` and the right child at `column + 1`.
3. Use a queue for level-order traversal so nodes are processed from top to bottom.
4. Store the first value encountered for each column in a `TreeMap` with `putIfAbsent`.
5. Iterate the map values from leftmost to rightmost column and return them.

Because BFS visits upper levels before lower levels, the first node stored for a column is the one visible from the top view.

- **Time Complexity:** O(N log N), where N is the number of nodes. `TreeMap` insertions and iteration add logarithmic overhead per column.
- **Space Complexity:** O(N), for the queue and the map.

# Bottom View of Binary Tree

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1)

## Problem Description

Given a binary tree, return the nodes visible when the tree is viewed from the bottom. If multiple nodes share the same horizontal distance, only the bottommost node is visible.

### Example

**Input:** `root = [20, 8, 22, 5, 3, 4, 25, null, null, 10, 14]`  
**Output:** `[5, 10, 3, 14, 25]`

**Input:** `root = [1, 3, 2]`  
**Output:** `[3, 1, 2]`

## Explanation

### Optimal BFS with TreeMap

This solution assigns each node a column index and uses breadth-first search to keep updating the node seen at each column.

1. Treat the root as column `0`.
2. Move to the left child at `column - 1` and the right child at `column + 1`.
3. Use a queue for level-order traversal so nodes are processed from top to bottom.
4. Store the latest value for each column in a `TreeMap` with `put`, overwriting earlier entries.
5. Iterate the map values from leftmost to rightmost column and return them.

Because BFS visits upper levels before lower levels, the last node stored for a column is the bottommost one visible in the bottom view.

- **Time Complexity:** O(N log N), where N is the number of nodes. `TreeMap` insertions and iteration add logarithmic overhead per column.
- **Space Complexity:** O(N), for the queue and the map.

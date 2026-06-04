# 102. Binary Tree Level Order Traversal

[Link to Problem on LeetCode](https://leetcode.com/problems/binary-tree-level-order-traversal/)

## Problem Description

Given the `root` of a binary tree, return _the level order traversal of its nodes' values_. (i.e., from left to right, level by level).

### Example

**Input:** `root = [3,9,20,null,null,15,7]`
**Output:** `[[3],[9,20],[15,7]]`

## Explanation

The solution uses a Breadth-First Search (BFS) approach, which is perfect for level-by-level traversal.

### BFS with a Queue

The core idea is to use a queue to process nodes at each level before moving to the next.

1.  **Initialization**:
    -   If the `root` is null, return an empty array.
    -   Create a `result` array to store the levels.
    -   Create a `queue` and add the `root` node to it.

2.  **Level-by-Level Traversal**:
    -   Loop as long as the `queue` is not empty.
    -   Inside the loop, first get the `levelSize`, which is the number of nodes currently in the queue. These are all the nodes for the current level.
    -   Create a `currentLevel` array to store the values of the nodes at this level.
    -   Loop `levelSize` times to process each node of the current level:
        -   Dequeue a `node` from the front of the queue.
        -   Add its value (`node.val`) to the `currentLevel` array.
        -   **Enqueue Children**: If the `node` has a left child, add it to the queue. If it has a right child, add it to the queue. These children will be processed in the next level's loop.
    -   After the inner loop finishes, push the `currentLevel` array into the `result` array.

3.  **Return**: Once the queue is empty, all levels have been processed. Return the `result` array.

-   **Time Complexity:** O(N) where N is the number of nodes in the tree, as we visit each node exactly once.
-   **Space Complexity:** O(W) where W is the maximum width of the tree. In the worst case (a complete binary tree), the last level can contain up to N/2 nodes, so the space complexity can be O(N).

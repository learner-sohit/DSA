# 200. Number of Islands

[Link to Problem on LeetCode](https://leetcode.com/problems/number-of-islands/)

## Problem Description

Given an `m x n` 2D binary grid `grid` of `'1'`s (land) and `'0'`s (water), return the **number of islands**.

An island is surrounded by water and is formed by connecting adjacent land cells **horizontally or vertically**.

### Example

**Input:**
```
grid = [["1","1","0","0","0"],
        ["1","1","0","0","0"],
        ["0","0","1","0","0"],
        ["0","0","0","1","1"]]
```

**Output:** `3`

**Explanation:** There are three separate groups of connected `'1'` cells, each forming one island.

---

## Approach: BFS — Count Connected Components of Land Cells

This problem reduces to **counting connected components** in a grid graph where nodes are land cells (`'1'`) and edges connect 4-directional neighbors.

For every unvisited land cell, increment the island counter and launch a BFS to mark the entire connected land region as visited so it won't be counted again.

### Algorithm

1. Initialize a `visited` boolean array of size `n × m`.
2. Iterate over every cell `(i, j)`:
   - If the cell is `'1'` and not yet visited → increment `count`, mark it visited, launch BFS from it.
3. In BFS:
   - Enqueue the starting cell.
   - For each dequeued cell, check all 4 neighbors — if in bounds, land, and unvisited → mark visited and enqueue.
4. Return `count`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(M × N) — every cell is enqueued and processed at most once |
| **Space** | O(M × N) — visited array + BFS queue |

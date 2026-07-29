# 1091. Shortest Path in Binary Matrix

[Link to Problem on LeetCode](https://leetcode.com/problems/shortest-path-in-binary-matrix/)

## Problem Description

Given an `n × n` binary matrix `grid`, find the length of the **shortest clear path** from the top-left cell `(0, 0)` to the bottom-right cell `(n-1, n-1)`.

A **clear path** only passes through cells with value `0` and can move in **8 directions** (horizontally, vertically, and diagonally). The path length is the number of cells visited.

Return `-1` if no clear path exists, or if either the source or destination cell is `1` (blocked).

### Example

**Input:**
```
grid = [[0,1],[1,0]]
```
**Output:** `2`

**Input:**
```
grid = [[0,0,0],[1,1,0],[1,1,0]]
```
**Output:** `4`

---

## Approach 1: Dijkstra-style BFS (dist array)

> Uses a separate `dist[n][m]` array initialized to `MAX_VALUE`. The path length starts at `1` (counting the source cell itself). For each cell, all 8 neighbors are explored and updated if a shorter distance is found.

### Algorithm

1. If `grid[0][0] == 1` or `grid[n-1][m-1] == 1` → return `-1`.
2. Initialize `dist[n][m] = MAX_VALUE`; set `dist[0][0] = 1`.
3. Enqueue `(dis=1, row=0, col=0)`.
4. BFS: for each dequeued cell, explore all 8 neighbors:
   - Skip if out of bounds, blocked (`grid[r][c] == 1`), or not improving distance.
   - Update `dist[r][c] = dis + 1` and enqueue.
5. Return `dist[n-1][m-1]` or `-1` if still `MAX_VALUE`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(N²) — each cell visited at most once |
| **Space** | O(N²) — dist array + BFS queue |

---

## Approach 2: Pure BFS (in-place visited marking)

> Instead of a separate `dist` array, marks cells as visited by setting `grid[r][c] = 1` in-place. Simpler and uses less extra space. Includes an early exit when `dest` is reached.

### Algorithm

1. If `grid[0][0] == 1` or `grid[n-1][m-1] == 1` → return `-1`.
2. Enqueue `(row=0, col=0, dis=1)`; mark `grid[0][0] = 1`.
3. BFS: for each dequeued cell:
   - If `(row, col) == (n-1, m-1)` → return `dis` (early exit).
   - Explore all 8 neighbors: if in bounds and `grid[r][c] == 0`, mark visited and enqueue.
4. Return `-1` if BFS exhausts without reaching destination.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(N²) |
| **Space** | O(N²) — queue only; grid used as visited marker (modifies input) |

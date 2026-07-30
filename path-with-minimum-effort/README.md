# 1631. Path With Minimum Effort

[Link to Problem on LeetCode](https://leetcode.com/problems/path-with-minimum-effort/)

## Problem Description

You are given an `n × m` matrix `heights` where `heights[r][c]` represents the height of cell `(r, c)`.

Find a path from the **top-left** `(0, 0)` to the **bottom-right** `(n-1, m-1)` moving in 4 directions (up, down, left, right) such that the **maximum absolute difference** in heights between any two consecutive cells along the path is **minimized**.

Return that minimum effort.

### Example

**Input:**
```
heights = [[1,2,2],[3,8,2],[5,3,5]]
```
**Output:** `2`

**Explanation:** The path `1 → 3 → 5 → 3 → 5` has a maximum effort of `2` (between `3` and `5`), which is the minimum possible.

---

## Approach: Dijkstra's Algorithm (Minimise Maximum Edge Weight)

> **Key Insight:** This is a variation of Dijkstra's where instead of minimising the *sum* of edge weights, we minimise the *maximum* edge weight along the path. The "effort" for a cell is defined as `max(current_effort, |heights[r][c] - heights[prev_row][prev_col]|)`. The min-heap always processes the path with the smallest current maximum effort first, guaranteeing the optimal result.

### Algorithm

1. Initialize `effort[n][m] = MAX_VALUE`; set `effort[0][0] = 0`.
2. Push `(row=0, col=0, diff=0)` into a **min-heap** ordered by `diff`.
3. While heap is not empty:
   - Poll the cell with minimum effort so far.
   - **Early exit:** if `(row, col) == (n-1, m-1)` → return `diff`.
   - For each of 4 neighbors: compute `newEffort = max(diff, |heights[r][c] - heights[row][col]|)`.
   - If `newEffort < effort[r][c]` → update and push.
4. Return `effort[n-1][m-1]`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(N × M × log(N × M)) — each cell processed with heap ops |
| **Space** | O(N × M) — effort array + priority queue |

# 542. 01 Matrix

[Link to Problem on LeetCode](https://leetcode.com/problems/01-matrix/)

## Problem Description

Given an `m x n` binary matrix `mat`, return the **distance of the nearest `0`** for each cell. The distance between two adjacent cells is `1`.

### Example

**Input:**
```
mat = [[0,0,0],
       [0,1,0],
       [1,1,1]]
```

**Output:**
```
[[0,0,0],
 [0,1,0],
 [1,2,1]]
```

**Explanation:** Each cell's value in the output is the shortest distance to the nearest `0` in the input.

---

## Approach: Multi-source BFS from all 0-cells

Instead of running BFS from every `1`-cell to find the nearest `0` (which would be O(M²N²)), we **flip the perspective**: seed the BFS queue with **all `0`-cells simultaneously at distance `0`**, then expand outward. Every `1`-cell gets assigned the distance the moment BFS first reaches it — which is guaranteed to be the shortest distance to any `0`.

This is the same multi-source technique used in [Rotting Oranges](../rotting-oranges/).

### Algorithm

1. Scan the matrix — enqueue every `0`-cell as `(row, col, time=0)` and mark it visited.
2. Run BFS:
   - Dequeue `(row, col, time)`, set `ans[row][col] = time`.
   - For each of the 4 neighbors, if in bounds and not yet visited:
     - Mark it visited and enqueue it as `(nrow, ncol, time + 1)`.
3. Return `ans`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(M × N) — every cell is enqueued and processed at most once |
| **Space** | O(M × N) — visited array + BFS queue + answer array |

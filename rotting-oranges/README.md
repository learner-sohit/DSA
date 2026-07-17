# 994. Rotting Oranges

[Link to Problem on LeetCode](https://leetcode.com/problems/rotting-oranges/)

## Problem Description

You are given an `m x n` grid where each cell contains one of three values:

- `0` — empty cell
- `1` — fresh orange
- `2` — rotten orange

Every minute, any fresh orange that is **4-directionally adjacent** to a rotten orange becomes rotten.

Return the **minimum number of minutes** that must elapse until no cell has a fresh orange. If it is impossible, return `-1`.

### Example

**Input:**
```
grid = [[2,1,1],
        [1,1,0],
        [0,1,1]]
```

**Output:** `4`

**Explanation:**
```
Minute 0: [[2,1,1], [1,1,0], [0,1,1]]
Minute 1: [[2,2,1], [2,1,0], [0,1,1]]
Minute 2: [[2,2,2], [2,2,0], [0,1,1]]
Minute 3: [[2,2,2], [2,2,0], [0,2,1]]
Minute 4: [[2,2,2], [2,2,0], [0,2,2]]
```

---

## Approach: Multi-source BFS

Instead of simulating one rotten orange at a time, enqueue **all initially rotten oranges simultaneously** at time `0`. BFS then spreads the rot in all directions level by level, where each level corresponds to one minute. Tracking a `time` field in each node gives the elapsed minutes without needing an explicit level counter.

### Algorithm

1. Scan the grid — enqueue every cell with value `2` at time `0`; count every cell with value `1` as `fresh`.
2. Run BFS:
   - Dequeue a cell `(row, col, time)` and update `maxTime`.
   - For each of the 4 neighbors, if the neighbor is a fresh orange:
     - Mark it as rotten (`grid[nrow][ncol] = 2`).
     - Decrement `fresh`.
     - Enqueue `(nrow, ncol, time + 1)`.
3. After BFS, return `maxTime` if `fresh == 0`, otherwise `-1`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(M × N) — every cell is visited at most once |
| **Space** | O(M × N) — BFS queue can hold all cells in the worst case |

# Shortest Path in a Binary Maze

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1)

## Problem Description

Given an `n × m` binary matrix `mat` where:
- `1` = passable cell
- `0` = blocked cell

Find the **shortest path** (minimum number of steps) from `src` to `dest` moving in 4 directions (up, down, left, right).

Return `-1` if no path exists or if `src` itself is blocked.

### Example

**Input:**
```
mat = [
  [1, 1, 1, 1],
  [1, 1, 0, 1],
  [0, 0, 0, 1],
  [1, 1, 1, 1]
]
src = [0, 0], dest = [3, 3]
```

**Output:** `6`

**Explanation:** Shortest path: `(0,0) → (0,1) → (0,2) → (0,3) → (1,3) → (2,3) → (3,3)` — 6 steps.

---

## Approach: BFS on Grid (Unit-Weight Shortest Path)

> **Key Insight:** Since every move costs exactly 1 step (unit weight), BFS naturally finds the shortest path by exploring cells level by level. The first time BFS reaches `dest`, it is guaranteed to be the shortest path.

### Algorithm

1. If `mat[src[0]][src[1]] == 0` → return `-1` immediately (source is blocked).
2. Initialize `dist[n][m] = MAX_VALUE`; set `dist[src] = 0`.
3. Enqueue `(dist=0, src_row, src_col)`.
4. BFS: for each dequeued cell, explore all 4 neighbors `(up, right, down, left)`:
   - Skip if out of bounds, blocked (`mat[r][c] == 0`), or not improving distance.
   - Otherwise update `dist[r][c] = dist + 1` and enqueue.
5. Return `dist[dest]` if reachable, else `-1`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(N × M) — each cell is visited at most once |
| **Space** | O(N × M) — dist array + BFS queue |

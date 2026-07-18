# 733. Flood Fill

[Link to Problem on LeetCode](https://leetcode.com/problems/flood-fill/)

## Problem Description

You are given an image represented as an `m x n` integer grid `image`, a starting pixel `(sr, sc)`, and an integer `color`.

Perform a **flood fill** on the image starting from pixel `(sr, sc)`:

1. Change the color of `(sr, sc)` to `color`.
2. Change the color of every pixel **4-directionally connected** to `(sr, sc)` that has the **same original color**, and so on recursively.

Return the modified image after performing the flood fill.

### Example

**Input:**
```
image = [[1,1,1],
         [1,1,0],
         [1,0,1]]
sr = 1, sc = 1, color = 2
```

**Output:**
```
[[2,2,2],
 [2,2,0],
 [2,0,1]]
```

**Explanation:** Starting from `(1,1)` with original color `1`, all 4-directionally connected pixels with color `1` are recolored to `2`. The bottom-right `1` at `(2,2)` is not connected and stays unchanged.

---

## Approach: BFS (Iterative Flood Fill)

Record the original color at the starting pixel. Use BFS to spread outward, recoloring every 4-directionally adjacent pixel that still holds the original color. The starting pixel is colored before entering the loop to avoid re-enqueuing it. An early-exit guard (original color == new color) prevents an infinite loop.

### Algorithm

1. If `image[sr][sc] == color`, return immediately (no change needed).
2. Save `toChange = image[sr][sc]`. Enqueue `(sr, sc)` and recolor it.
3. While the queue is not empty:
   - Dequeue pixel `(row, col)`.
   - For each of the 4 neighbors `(nrow, ncol)`:
     - If in bounds and `image[nrow][ncol] == toChange`, recolor it and enqueue it.
4. Return the modified `image`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(M × N) — each pixel is enqueued and processed at most once |
| **Space** | O(M × N) — BFS queue can hold all pixels in the worst case |

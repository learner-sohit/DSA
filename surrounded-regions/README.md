# 130. Surrounded Regions

[Link to Problem on LeetCode](https://leetcode.com/problems/surrounded-regions/)

## Problem Description

Given an `m x n` board containing `'X'` and `'O'`, **capture** all regions that are 4-directionally surrounded by `'X'` by flipping all `'O'`s in those regions to `'X'`.

A region is **not** captured if any `'O'` in it touches the border of the board.

### Example

**Input:**
```
X X X X
X O O X
X X O X
X O X X
```

**Output:**
```
X X X X
X X X X
X X X X
X O X X
```

**Explanation:** The `'O'`s in the interior that are fully surrounded are flipped to `'X'`. The `'O'` at `(3,1)` touches the border (connected to a border `'O'`) so it remains.

---

## Approach: Boundary DFS (Reverse Thinking)

Rather than searching for surrounded regions directly (which is hard), we **reverse the problem**: find all `'O'`s that are *safe* (border-connected) and mark them, then flip everything else.

1. Any `'O'` on the border cannot be captured.
2. Any `'O'` connected to a border `'O'` cannot be captured either.
3. All other `'O'`s are surrounded → flip them to `'X'`.

### Algorithm

1. Run DFS from every `'O'` on the **four borders**, marking all reachable `'O'`s as visited (safe).
2. After all border DFS calls, scan the entire board:
   - If a cell is `'O'` and **not visited** → it is surrounded → flip to `'X'`.
   - If it is visited or already `'X'` → leave it unchanged.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(M × N) — every cell is visited at most once |
| **Space** | O(M × N) — visited array + recursion call stack |

# 1020. Number of Enclaves

[Link to Problem on LeetCode](https://leetcode.com/problems/number-of-enclaves/)

## Problem Description

You are given an `m x n` binary matrix `grid`, where:
- `0` represents a sea cell
- `1` represents a land cell

A land cell is an **enclave** if you cannot reach the boundary of the grid by moving 4-directionally through land cells only.

Return the **number of land cells** in the grid that are enclaves.

### Example

**Input:**
```
grid = [[0,0,0,0],
        [1,0,1,0],
        [0,1,1,0],
        [0,0,0,0]]
```

**Output:** `3`

**Explanation:** The three `1`s at `(1,2)`, `(2,1)`, and `(2,2)` form an enclosed island. The `1` at `(1,0)` touches the border, so it is not an enclave.

---

## Approach: Boundary DFS (same pattern as [Surrounded Regions](../surrounded-regions/))

Any land cell connected to the border **cannot** be an enclave. So we:
1. Mark all border-connected land cells as visited (safe) using DFS.
2. Count all remaining unvisited land cells — these are the enclaves.

> **Optimization note:** The visited array can be eliminated by flipping border-reachable `1`s to `0` in-place, reducing space to O(M×N) call stack only.

### Algorithm

1. Run DFS from every `1`-cell on all **four borders**, marking reachable land as visited.
2. Scan the entire grid — for each cell that is `1` and **not visited**, increment `count`.
3. Return `count`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(M × N) — every cell is visited at most once |
| **Space** | O(M × N) — visited array + recursion call stack |

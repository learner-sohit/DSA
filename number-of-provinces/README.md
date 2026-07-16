# 547. Number of Provinces

[Link to Problem on LeetCode](https://leetcode.com/problems/number-of-provinces/)

## Problem Description

There are `n` cities. Some of them are connected directly; others are not. If city `a` is connected to city `b`, and city `b` is connected to city `c`, then city `a` is connected to city `c`.

A **province** is a group of directly or indirectly connected cities with no other cities outside the group.

Given an `n x n` matrix `isConnected` where `isConnected[i][j] == 1` if city `i` and city `j` are directly connected and `isConnected[i][j] == 0` otherwise, return the total number of **provinces**.

### Example

**Input:**
```
isConnected = [[1,1,0],[1,1,0],[0,0,1]]
```

**Output:** `2`

**Explanation:** Cities 0 and 1 are connected, forming one province. City 2 is isolated, forming a second province.

---

## Approach: DFS on Adjacency Matrix

Instead of building an explicit adjacency list, we treat the `isConnected` matrix directly as a graph. For every unvisited city, we launch a DFS that marks all reachable cities in the same connected component as visited, then count that component as one province.

### Algorithm

1. Initialize a `visited` boolean array of size `n` (all `false`).
2. Iterate over every city `i` from `0` to `n-1`:
   - If city `i` is not yet visited, run DFS from `i` and increment `provinces`.
3. In the DFS helper:
   - Mark the current node as visited.
   - Scan its row in `isConnected`; for every directly connected and unvisited neighbor, recurse.
4. Return `provinces`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V²) — for each node we scan its entire row in the matrix |
| **Space** | O(V) — visited array + recursion call stack |

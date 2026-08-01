# 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance

[Link to Problem on LeetCode](https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/)

## Problem Description

There are `n` cities numbered from `0` to `n-1`. Given the array `edges` where `edges[i] = [from_i, to_i, weight_i]` represents a bidirectional and weighted edge between cities `from_i` and `to_i`, and given the integer `distanceThreshold`.

Return the city with the smallest number of cities that are reachable through some path and whose distance is **at most** `distanceThreshold`. If there are multiple such cities, return the city with the greatest number.

### Example

**Input:**
```
n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
```
**Output:** `3`

**Explanation:**
The neighbor cities at a distanceThreshold = 4 for each city are:
- City 0 -> [City 1, City 2]
- City 1 -> [City 0, City 2, City 3]
- City 2 -> [City 0, City 1, City 3]
- City 3 -> [City 1, City 2]

Cities 0 and 3 have 2 neighbor cities at a distanceThreshold = 4, but we have to return City 3 because it has the greatest number.

---

## Approach: Floyd-Warshall Algorithm (All-Pairs Shortest Path)

> **Key Insight:** To count how many cities each city can reach within `distanceThreshold`, we need the shortest distance between **all pairs of cities**. Floyd-Warshall computes the `n x n` shortest distance matrix in $O(N^3)$ time. Once computed, we iterate over each city `i`, count how many cities `j` satisfy `dist[i][j] <= distanceThreshold`, and pick the city with the minimum count (tie-broken by picking the larger city index `i`).

### Algorithm

1. Initialize an `n x n` matrix `dist` with `Integer.MAX_VALUE`, set `dist[i][i] = 0`.
2. Populate direct edge weights from `edges` (both directions, as graph is undirected).
3. Run Floyd-Warshall 3-nested loops ($k, i, j$) to find all-pairs shortest paths.
4. For each city `i` from `0` to `n-1`:
   - Count how many cities `j` have `dist[i][j] <= distanceThreshold`.
   - If `cnt <= cntCity` (using `<=`), update `cntCity = cnt` and `city = i` (this automatically picks the larger city index on tie due to iteration order `0` to `n-1`).
5. Return `city`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(N³) — 3 nested loops of size N for Floyd-Warshall |
| **Space** | O(N²) — N x N matrix to store shortest distances |

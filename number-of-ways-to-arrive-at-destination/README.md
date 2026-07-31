# 1976. Number of Ways to Arrive at Destination

[Link to Problem on LeetCode](https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/)

## Problem Description

You are given `n` intersections labeled `0` to `n-1` and a list of `roads` where `roads[i] = [u, v, time]` represents a bidirectional road between `u` and `v` with travel time `time`.

Find the **number of ways** you can travel from intersection `0` to intersection `n-1` in the **shortest possible time**. Return the answer modulo `1_000_000_007`.

### Example

**Input:**
```
n = 7
roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
```
**Output:** `4`

**Explanation:** The shortest time to reach node 6 is `7`. There are 4 different paths that achieve this.

---

## Approach: Dijkstra's Algorithm + Way Count

> **Key Insight:** Run Dijkstra's while maintaining a parallel `ways[]` array alongside `dist[]`. For each neighbor:
> - **Shorter path found** → update `dist[adjNode]` and **reset** `ways[adjNode] = ways[node]` (the only way is through this new shorter path).
> - **Equal path found** → `dist[adjNode]` stays the same, but **add** `ways[node]` to `ways[adjNode]` (another equally short path discovered).
>
> This counts all shortest paths in a single Dijkstra pass.

### Algorithm

1. Build an **undirected** weighted adjacency list from `roads`.
2. Initialize `dist[n] = MAX_VALUE`, `dist[0] = 0`; `ways[0] = 1`.
3. Push `[node=0, time=0]` into a **min-heap**.
4. Dijkstra's: poll min node; skip if stale (`time > dist[node]`).
   - For each neighbor: if `time + edgeWt < dist[adjNode]` → update dist, reset ways, push.
   - If `time + edgeWt == dist[adjNode]` → add `ways[node]` to `ways[adjNode]` (mod).
5. Return `ways[n-1]`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O((N + E) log N) — standard Dijkstra with extra O(1) way-count update per edge |
| **Space** | O(N + E) — adjacency list + dist array + ways array + heap |

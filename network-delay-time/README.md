# 743. Network Delay Time

[Link to Problem on LeetCode](https://leetcode.com/problems/network-delay-time/)

## Problem Description

You are given a network of `n` nodes labeled `1` to `n`, and a list of travel times `times[i] = [u, v, w]` representing a directed edge from `u` to `v` with travel time `w`.

A signal is sent from node `k`. Return the **minimum time** it takes for all `n` nodes to receive the signal. Return `-1` if it is impossible.

### Example

**Input:**
```
times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
```
**Output:** `2`

**Explanation:**
- Node 1: 2 → 1, time = 1
- Node 3: 2 → 3, time = 1
- Node 4: 2 → 3 → 4, time = 2

All nodes receive the signal by time `2`.

---

## Approach 1: Dijkstra's + Stale Entry Check (Active)

> **Key Insight:** Run Dijkstra's from source `k`. The answer is the **maximum** shortest distance across all nodes — the signal must reach the *last* node. With the stale entry check (`if time > dist[node] → skip`), we avoid redundant processing of outdated heap entries. Final pass iterates all nodes `1..n` and returns `-1` immediately if any is unreachable.

### Algorithm

1. Build a directed adjacency list from `times`.
2. Initialize `dist[n+1] = MAX_VALUE`; set `dist[k] = 0`.
3. Push `[time=0, node=k]` into a **min-heap**.
4. Dijkstra's: poll min node; **skip if stale** (`time > dist[node]`); relax outgoing edges.
5. Final pass: if any `dist[i] == MAX_VALUE` → return `-1`; else return `max(dist[1..n])`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O((N + E) log N) |
| **Space** | O(N + E) |

---

## Approach 2: Dijkstra's (no stale check, skip src in final pass)

> Same algorithm without the stale entry check. Final pass skips the source node `k` and uses `ans = -1` as sentinel, returning `-1` if the max is still `MAX_VALUE`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O((N + E) log N) |
| **Space** | O(N + E) |

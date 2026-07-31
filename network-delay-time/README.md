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

## Approach: Dijkstra's Algorithm (Single Source Shortest Path)

> **Key Insight:** Run Dijkstra's from source `k` to find the shortest path to every other node. The answer is the **maximum** of all shortest distances — because the signal must reach the *last* node to arrive. If any node is unreachable (`dist[i] == MAX_VALUE`), return `-1`.

### Algorithm

1. Build a directed adjacency list from `times`.
2. Initialize `dist[n+1] = MAX_VALUE`; set `dist[k] = 0`.
3. Push `[time=0, node=k]` into a **min-heap** (ordered by time).
4. Dijkstra's BFS: for each polled node, relax all outgoing edges; if `time + edgeWt < dist[adjNode]` → update and push.
5. After BFS, iterate nodes `1..n` (skip `k`): track the maximum `dist[i]`.
6. Return `max` if no node is still at `MAX_VALUE`, else return `-1`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O((N + E) log N) — each node/edge processed with heap operations |
| **Space** | O(N + E) — adjacency list + dist array + priority queue |

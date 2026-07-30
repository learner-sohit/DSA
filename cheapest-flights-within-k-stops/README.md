# 787. Cheapest Flights Within K Stops

[Link to Problem on LeetCode](https://leetcode.com/problems/cheapest-flights-within-k-stops/)

## Problem Description

There are `n` cities connected by `flights` where `flights[i] = [from, to, price]` represents a directed flight.

Find the **cheapest price** to travel from `src` to `dst` using **at most `k` stops**. Return `-1` if no such route exists.

### Example

**Input:**
```
n = 4, src = 0, dst = 3, k = 1
flights = [[0,1,100],[1,2,100],[0,2,500],[2,3,100],[1,3,600]]
```
**Output:** `700`

**Explanation:** `0 → 2 → 3` costs `500 + 100 = 600`, but uses 1 stop (2). `0 → 1 → 3` costs `100 + 600 = 700` with 1 stop. The cheapest valid path is `0 → 1 → 2 → 3` but that's 2 stops — exceeds `k=1`. So the answer is `700`.

---

## Approach: BFS with Stop Count (Modified Dijkstra)

> **Key Insight:** Standard Dijkstra minimises cost but ignores the stop constraint. Here we use a **plain queue (BFS)** instead of a min-heap, ordered by number of stops rather than cost. Each entry tracks `[stops, node, cost]`. We skip any path that has exceeded `k` stops, and only update `dist[nextNode]` if the new cost is cheaper. This naturally limits exploration to paths within `k+1` edges.

### Algorithm

1. Build a directed adjacency list from `flights`.
2. Initialize `dist[n] = MAX_VALUE`; set `dist[src] = 0`.
3. Enqueue `[stops=0, src, cost=0]`.
4. BFS: for each dequeued entry:
   - If `stops > k` → skip (exceeded allowed stops).
   - For each neighbor: if `cost + edgeWt < dist[nextNode]` → update and enqueue with `stops + 1`.
5. Return `dist[dst]` or `-1` if still `MAX_VALUE`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(n + flights × k) — BFS explores at most k+1 levels |
| **Space** | O(n + flights) — adjacency list + dist array + queue |

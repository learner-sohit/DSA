# Minimum Steps to Reach End

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/minimum-steps-to-reach-end/0)

## Problem Description

Given an array `arr[]` of multipliers, a `start` value, and an `end` value, find the **minimum number of multiplication steps** to convert `start` to `end`.

At each step, the current value is multiplied by any element from `arr[]`, and the result is taken **modulo 1000**. Return `-1` if it is not possible to reach `end`.

### Example

**Input:**
```
arr = [2, 5, 7], start = 3, end = 30
```
**Output:** `2`

**Explanation:** `3 × 2 = 6`, then `6 × 5 = 30`. Reached `end` in 2 steps.

---

## Approach: BFS on Modular State Space

> **Key Insight:** Since all values are taken modulo 1000, there are at most **1000 unique states** (0 to 999). Model this as an unweighted graph where each state `node` connects to `(node × arr[i]) % 1000` for every multiplier. BFS finds the shortest path (minimum steps) in this state space.
>
> An early exit is applied: the moment `end` is generated as a neighbor, return `cost + 1` immediately — BFS guarantees this is optimal.

### Algorithm

1. Normalize `start = start % 1000`. If `start == end` → return `0`.
2. Initialize `dist[1000] = MAX_VALUE`; set `dist[start] = 0`.
3. Enqueue `[node=start, cost=0]`.
4. BFS: for each dequeued node, try all multipliers:
   - Compute `newNode = (node × arr[i]) % 1000`.
   - If `cost + 1 < dist[newNode]` → update dist, early-exit if `newNode == end`, else enqueue.
5. Return `-1` if BFS exhausts without reaching `end`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(1000 × \|arr\|) — at most 1000 unique states, each expanded once |
| **Space** | O(1000) — dist array + BFS queue |

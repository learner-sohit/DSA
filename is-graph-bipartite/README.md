# 785. Is Graph Bipartite?

[Link to Problem on LeetCode](https://leetcode.com/problems/is-graph-bipartite/)

## Problem Description

A graph is **bipartite** if we can split its nodes into two independent subsets `A` and `B` such that **every edge** connects a node in `A` to a node in `B`.

Given an adjacency list `graph` of `n` nodes (0-indexed), return `true` if the graph is bipartite, `false` otherwise.

### Example

**Input:**
```
graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
```

**Output:** `false`

**Explanation:** Node 0 is connected to 1, 2, and 3. If 0 is in set A, then 1, 2, 3 must all be in set B. But 1 and 2 are also connected to each other — both in B — which violates the bipartite condition.

---

## Approach: BFS 2-Coloring

A graph is bipartite **if and only if** it can be colored using exactly 2 colors such that no two adjacent nodes share the same color. We verify this using BFS:

- Assign the starting node color `0`.
- For each neighbor, assign the opposite color (`1 - color`).
- If a neighbor is already colored with the **same color** as the current node → contradiction → **not bipartite**.

The outer `for` loop ensures disconnected components are also checked.

### Algorithm

1. Initialize a `color` array of size `V` with `-1` (uncolored).
2. For each uncolored node `i`:
   - Assign color `0`, enqueue it.
   - BFS: for each dequeued node, scan its neighbors:
     - Uncolored → assign opposite color, enqueue.
     - Same color as current node → return `false`.
3. If no contradiction found → return `true`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E) — each node and edge is processed once |
| **Space** | O(V) — color array + BFS queue |

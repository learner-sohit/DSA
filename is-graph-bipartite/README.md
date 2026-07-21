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

## Approach 1: BFS 2-Coloring

Try to color the graph with 2 colors so no two adjacent nodes share the same color. Assign color `0` to the source and use BFS to assign the opposite color (`1 - color`) to every neighbor. If a neighbor already has the **same color** as the current node → contradiction → not bipartite.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E) — each node and edge is processed once |
| **Space** | O(V) — color array + BFS queue |

---

## Approach 2: DFS 2-Coloring

Same 2-coloring logic as BFS, but using **recursive DFS**. Assign color `0` to the source, then recursively assign the opposite color to each uncolored neighbor. If a colored neighbor matches the current node's color → return `false` immediately.

### Algorithm

1. Initialize `color` array with `-1` (uncolored).
2. For each uncolored node `i`, assign color `0` and call `dfs(i, ...)`.
3. In DFS: for each neighbor `adjNode`:
   - Uncolored → assign opposite color, recurse; propagate `false` if returned.
   - Same color as current node → return `false`.
4. If no contradiction found → return `true`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E) — each node and edge is processed once |
| **Space** | O(V) — color array + recursion call stack |

# Detect Cycle in a Directed Graph

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1)

## Problem Description

Given a directed graph with `V` vertices (numbered `0` to `V-1`) and a list of directed edges, determine whether the graph contains a **cycle**.

Return `true` if a cycle exists, `false` otherwise.

### Example

**Input:**
```
V = 4, edges = [[0,1],[1,2],[2,3],[3,1]]
```

**Output:** `true`

**Explanation:** The path 1 → 2 → 3 → 1 forms a cycle.

---

## Approach: DFS with Path-Visited Tracking

> **Why not use the undirected cycle detection approach?**
> In an undirected graph, any visited neighbor (except the parent) signals a cycle. In a directed graph, reaching a visited node does **not** mean a cycle exists — it could be a cross edge from a different path. A cycle exists only if we reach a node that is **already on the current active DFS path**.

We maintain two boolean arrays:
- **`visited[]`** — globally marks nodes that have been visited in any DFS call.
- **`pathVisited[]`** — marks nodes currently on the active DFS stack (current path only).

On backtracking from a node, its `pathVisited` flag is reset to `false`.

### Algorithm

1. Build a directed adjacency list from `edges`.
2. Initialize `visited[]` and `pathVisited[]` arrays of size `V`.
3. For each unvisited node `i`, call `dfs(i, ...)`.
4. In DFS:
   - Mark `node` in both `visited` and `pathVisited`.
   - For each neighbor `adjNode`:
     - If **unvisited** → recurse; propagate `true` if returned.
     - If **visited AND on current path** (`pathVisited[adjNode] == true`) → **cycle found**, return `true`.
   - Before returning, reset `pathVisited[node] = false` (backtrack).
5. If no cycle found across all components → return `false`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E) — each vertex and edge is processed once |
| **Space** | O(V) — two boolean arrays + recursion call stack |

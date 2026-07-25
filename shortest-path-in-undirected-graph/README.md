# Shortest Path in Undirected Graph

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1)

## Problem Description

Given an undirected graph with `V` vertices and **unit-weight** edges, find the length of the shortest path (minimum number of edges) from `src` to `dest`.

Return `-1` if no path exists between them.

### Example

**Input:**
```
V = 8, src = 0, dest = 5
edges = [[0,1],[0,3],[1,2],[3,4],[4,5],[5,6],[6,7]]
```

**Output:** `3`

**Explanation:** Shortest path is `0 → 3 → 4 → 5`, which has 3 edges.

---

## Approach: BFS (Shortest Path in Unweighted Graph)

> **Key Insight:** In an **unweighted** graph, BFS is the ideal algorithm for finding the shortest path. BFS explores nodes **level by level** — each level corresponds to nodes exactly one edge further from the source. So the first time BFS reaches the destination, it is guaranteed to be via the shortest path.

### Algorithm

1. Build an **undirected adjacency list** from the given edges.
2. Initialize `dist[]` array with `Integer.MAX_VALUE` (unvisited); set `dist[src] = 0`.
3. Enqueue `src`.
4. BFS:
   - Dequeue node; if it equals `dest` → return `dist[node]` immediately (early exit).
   - For each neighbor `adjNode`: if `dist[node] + 1 < dist[adjNode]`, update `dist[adjNode]` and enqueue.
5. After BFS, if `dist[dest]` is still `MAX_VALUE` → no path found → return `-1`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E) — each vertex and edge is visited once |
| **Space** | O(V + E) — adjacency list + dist array + BFS queue |

# Bellman-Ford Algorithm

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1)

## Problem Description

Given a directed weighted graph with `V` vertices and a list of edges `[u, v, wt]` (which may include **negative weights**), find the shortest distance from source `src` to all other vertices.

Return `{-1}` if a **negative weight cycle** is reachable from `src`.

### Example

**Input:**
```
V = 5, src = 0
edges = [[0,1,5],[1,2,-3],[2,4,3],[0,3,2],[3,4,6]]
```
**Output:** `[0, 5, 2, 2, 5]`

---

## Approach: Bellman-Ford Algorithm

> **Why not Dijkstra?** Dijkstra fails on negative edge weights because it assumes once a node is popped from the heap its distance is final. Bellman-Ford handles negative weights by repeatedly relaxing all edges.

> **Key Insight:** In a graph with `V` vertices, any shortest path contains at most `V-1` edges (no cycles on a shortest path). So relaxing all edges `V-1` times is guaranteed to settle all shortest distances. A **Vth relaxation pass** that still finds improvements indicates a negative weight cycle.

### Algorithm

1. Initialize `dist[V] = INF`; set `dist[src] = 0`.
2. Repeat `V-1` times:
   - For each edge `(u, v, wt)`: if `dist[u] != INF` and `dist[u] + wt < dist[v]` → update `dist[v]`.
3. **Negative cycle check (Nth pass):** Run one more pass over all edges — if any `dist[v]` can still be reduced → negative cycle exists → return `{-1}`.
4. Return `dist[]`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V × E) — V-1 relaxation passes, each iterating over all E edges |
| **Space** | O(V) — dist array only |

### Bellman-Ford vs Dijkstra

| | Bellman-Ford | Dijkstra |
|---|---|---|
| **Negative weights** | ✅ Handles | ❌ Fails |
| **Negative cycles** | ✅ Detects | ❌ Cannot detect |
| **Time Complexity** | O(V × E) | O((V + E) log V) |
| **Best for** | Sparse graphs with negative weights | Dense graphs, non-negative weights |

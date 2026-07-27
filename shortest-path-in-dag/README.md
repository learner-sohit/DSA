# Shortest Path in a DAG

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1)

## Problem Description

Given a **Directed Acyclic Graph (DAG)** with `V` vertices and `E` weighted edges, find the shortest distance from **source node 0** to all other nodes.

Return `-1` for nodes that are unreachable from the source.

### Example

**Input:**
```
V = 6, E = 7
edges = [[0,1,2],[0,4,1],[1,2,3],[2,3,6],[4,2,2],[4,5,4],[5,3,1]]
```

**Output:** `[0, 2, 3, 6, 1, 5]`

**Explanation:**
- `0 → 0` : 0
- `0 → 1` : 2
- `0 → 4 → 2` : 1 + 2 = 3
- `0 → 4 → 5 → 3` : 1 + 4 + 1 = 6
- `0 → 4` : 1
- `0 → 4 → 5` : 1 + 4 = 5

---

## Approach: Topological Sort (DFS) + Edge Relaxation

> **Why not BFS/Dijkstra?** BFS only works for unit-weight graphs. Dijkstra works for weighted graphs but has O((V + E) log V) complexity. For a **DAG**, we can exploit the topological ordering to solve shortest paths in a single linear pass — **O(V + E)**.

> **Key Insight:** In a DAG, if we process nodes in **topological order**, we're guaranteed that when we process a node, all nodes that could contribute to its shortest distance have already been processed. This allows us to relax edges in a single forward pass.

### Algorithm

1. **Build** a directed weighted adjacency list from `edges`.
2. **Topological Sort** via DFS: perform DFS from every unvisited node; push each node onto a stack *after* all its descendants are processed.
3. **Initialize** `dist[0] = 0`, all others = `Integer.MAX_VALUE`.
4. **Relax edges** in topological order (pop from stack):
   - If `dist[node]` is not `MAX_VALUE` and `dist[node] + wt < dist[v]`, update `dist[v]`.
5. **Replace** any remaining `MAX_VALUE` with `-1` (unreachable nodes).

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E) — DFS topological sort + single relaxation pass |
| **Space** | O(V + E) — adjacency list + dist array + visited array + stack |

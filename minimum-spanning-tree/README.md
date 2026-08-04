# Minimum Spanning Tree (Kruskal's Algorithm)

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1)

## Problem Description

Given a weighted **undirected** graph with `V` vertices and a list of edges `[u, v, wt]`, find the **sum of weights** of the edges that form the **Minimum Spanning Tree (MST)**.

An MST is a subset of edges that:
- Connects all vertices (spanning).
- Has no cycles.
- Has the minimum possible total edge weight.

### Example

**Input:**
```
V = 5
edges = [[0,1,2],[0,3,6],[1,2,3],[1,3,8],[1,4,5],[2,4,7],[3,4,9]]
```
**Output:** `16`

**Explanation:** MST edges: `(0,1,2)`, `(1,2,3)`, `(1,4,5)`, `(0,3,6)` → sum = 16.

---

## Approach 1: Kruskal's Algorithm (Sort Edges + Union-Find)

> **Key Insight:** Sort all edges by weight in ascending order. Greedily pick the cheapest edge — add it to the MST only if it doesn't form a cycle. Cycle detection is done in near O(1) using a **Disjoint Set (Union-Find)** with path compression and union by size.

### Algorithm

1. Sort all edges by weight in ascending order.
2. Initialize a `DisjointSet` of size `V`.
3. For each edge `(u, v, wt)` in sorted order:
   - If `findParent(u) != findParent(v)` → no cycle → add `wt` to `mstWt`, call `unionBySize(u, v)`.
4. Return `mstWt`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(E log E) — dominated by sorting edges |
| **Space** | O(V) — Disjoint Set arrays |

---

## Approach 2: Prim's Algorithm (Greedy + Min-Heap)

> Grows MST from a source node, always picking the cheapest edge connecting an unvisited node. Uses a min-heap for efficient minimum selection.

### Algorithm

1. Build adjacency list; push `[wt=0, node=0]` into min-heap.
2. While heap is not empty: poll min, skip if visited; mark visited, add weight, push all unvisited neighbors.
3. Return total weight.

### Complexity

| | Complexity |
|---|---|
| **Time** | O((V + E) log V) |
| **Space** | O(V + E) |

---

## Kruskal's vs Prim's

| | Kruskal's | Prim's |
|---|---|---|
| **Approach** | Sort all edges, add if no cycle | Grow MST node by node |
| **Data Structure** | Union-Find (Disjoint Set) | Min-heap + visited array |
| **Best for** | Sparse graphs | Dense graphs |
| **Complexity** | O(E log E) | O((V + E) log V) |

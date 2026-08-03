# Minimum Spanning Tree (Prim's Algorithm)

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

## Approach: Prim's Algorithm (Greedy + Min-Heap)

> **Key Insight:** Prim's algorithm builds the MST greedily — always picking the **cheapest edge** that connects a new (unvisited) vertex to the growing MST. A min-heap ensures we always process the minimum weight edge efficiently.

### Algorithm

1. Build an **undirected** weighted adjacency list.
2. Initialize `visited[V] = false`; push `[wt=0, node=0]` into a **min-heap**.
3. While heap is not empty:
   - Poll the minimum weight edge `[wt, node]`.
   - If `visited[node]` → skip (already in MST).
   - Mark `visited[node] = true`; add `wt` to `sum`.
   - For each unvisited neighbor → push `[edgeWt, adjNode]` into heap.
4. Return `sum`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O((V + E) log V) — each node/edge processed with heap operations |
| **Space** | O(V + E) — adjacency list + visited array + priority queue |

### Prim's vs Kruskal's

| | Prim's | Kruskal's |
|---|---|---|
| **Approach** | Grow MST from a node | Sort all edges, add if no cycle |
| **Data Structure** | Min-heap + visited array | Union-Find (Disjoint Set) |
| **Best for** | Dense graphs | Sparse graphs |
| **Complexity** | O((V + E) log V) | O(E log E) |

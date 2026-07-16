# BFS of Graph

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1)

## Problem Description

Given a directed graph with `V` vertices (numbered `0` to `V-1`) represented as an adjacency list `adj`, perform a **Breadth First Search (BFS)** starting from vertex `0` and return the BFS traversal of the graph.

### Example

**Input:**
```
V = 5, adj = [[1, 2], [3], [4], [], []]
```

**Output:** `[0, 1, 2, 3, 4]`

**Explanation:** Starting from vertex 0, we visit its neighbors 1 and 2 first (level 1), then their neighbors 3 and 4 (level 2), giving BFS order: 0 → 1 → 2 → 3 → 4.

---

## Approach: BFS using Queue

BFS explores the graph **level by level** — visiting all neighbors of a node before moving to the next depth.

### Algorithm

1. Initialize a `visited` boolean array of size `V` (all `false`).
2. Create an empty result list `ans` and a `Queue`.
3. Enqueue source vertex `0` and mark it as visited.
4. While the queue is not empty:
   - Dequeue the front node, add it to `ans`.
   - For each neighbor of the dequeued node:
     - If not yet visited, enqueue it and mark as visited.
5. Return `ans`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E) — each vertex and edge is processed once |
| **Space** | O(V) — for the visited array and the queue |

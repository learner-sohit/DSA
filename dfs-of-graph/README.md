# DFS of Graph

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1)

## Problem Description

Given a connected undirected graph with `V` vertices (numbered `0` to `V-1`) represented as an adjacency list `adj`, perform a **Depth First Search (DFS)** starting from vertex `0` and return the DFS traversal of the graph.

### Example

**Input:**
```
adj = [[1, 2], [0, 3, 4], [0], [1], [1, 5], [4]]
```

**Output:** `[0, 1, 3, 4, 5, 2]`

**Explanation:** Starting from vertex 0, DFS explores as far as possible along each branch before backtracking. It visits 0 → 1 → 3 (backtrack) → 4 → 5 (backtrack to 0) → 2.

---

## Approach: DFS using Recursion

DFS explores the graph **depth first** — going as deep as possible along each path before backtracking.

### Algorithm

1. Initialize a `visited` boolean array of size `V` (all `false`).
2. Create an empty result list `ans`.
3. Call the recursive helper starting from vertex `0`.
4. In the helper:
   - Mark the current node as visited and add it to `ans`.
   - For each neighbor of the current node:
     - If not yet visited, recursively call the helper on it.
5. Return `ans`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E) — each vertex and edge is processed once |
| **Space** | O(V) — for the visited array and the recursion call stack |

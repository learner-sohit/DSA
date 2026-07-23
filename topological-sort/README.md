# Topological Sort

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/topological-sort/1)

## Problem Description

Given a **Directed Acyclic Graph (DAG)** with `V` vertices (numbered `0` to `V-1`) and a list of directed edges, return a valid **topological ordering** of its vertices.

In a topological order, for every directed edge `u → v`, vertex `u` must appear **before** `v` in the ordering.

> **Note:** A topological sort is only possible for DAGs (graphs with no cycles).

### Example

**Input:**
```
V = 6, edges = [[5,2],[5,0],[4,0],[4,1],[2,3],[3,1]]
```

**Output:** `[5, 4, 2, 3, 1, 0]` *(one valid ordering)*

**Explanation:** Every edge goes from a node that appears earlier to one that appears later in the output list.

---

## Approach: DFS + Stack (Reverse Finish Order)

Run DFS on every unvisited node. A node is pushed to the stack **only after all of its descendants have been fully explored** (post-order). This guarantees that when we pop the stack, every node appears before the nodes it points to.

### Algorithm

1. Build a directed adjacency list from `edges`.
2. Initialize a `visited` boolean array of size `V` and an empty `Stack`.
3. For each unvisited node `i`, call `dfs(i, ...)`.
4. In DFS:
   - Mark `node` as visited.
   - Recursively visit all unvisited neighbors.
   - After all neighbors are done → `st.push(node)`.
5. Pop all elements from the stack into the result list and return it.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E) — each vertex and edge is processed once |
| **Space** | O(V) — visited array + stack + recursion call stack |

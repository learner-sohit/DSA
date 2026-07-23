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

---

## Approach 1: DFS + Stack (Reverse Finish Order)

Run DFS on every unvisited node. A node is pushed to the stack **only after all of its descendants have been fully explored** (post-order). Popping the stack gives a valid topological order.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E) — each vertex and edge is processed once |
| **Space** | O(V) — visited array + stack + recursion call stack |

---

## Approach 2: BFS / Kahn's Algorithm (Indegree-based)

Compute the **in-degree** (number of incoming edges) for every node. Nodes with in-degree `0` have no prerequisites and can be processed first. After processing a node, decrement the in-degree of its neighbors — any that reach `0` are ready and get enqueued next.

> **Bonus:** If the final result contains fewer than `V` nodes, the graph has a cycle (not a valid DAG).

### Algorithm

1. Build a directed adjacency list from `edges`.
2. Compute `indegree[]` for all nodes.
3. Enqueue all nodes with `indegree == 0`.
4. BFS:
   - Dequeue a node, add it to `ans`.
   - For each neighbor, decrement its in-degree; if it reaches `0`, enqueue it.
5. Return `ans`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E) — each vertex and edge is processed once |
| **Space** | O(V) — indegree array + BFS queue |

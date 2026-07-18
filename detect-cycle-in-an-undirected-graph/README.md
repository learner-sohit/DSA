# Detect Cycle in an Undirected Graph

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1)

## Problem Description

Given an undirected graph with `V` vertices (numbered `0` to `V-1`) and a list of edges, determine whether the graph contains a **cycle**.

Return `true` if a cycle exists, `false` otherwise.

### Example

**Input:**
```
V = 4, edges = [[0,1],[1,2],[2,0],[2,3]]
```

**Output:** `true`

**Explanation:** Vertices 0 → 1 → 2 → 0 form a cycle.

---

## Approach 1: BFS with Parent Tracking

For every unvisited vertex, run a BFS and record each node's **parent** (the node it was discovered from). While expanding a node's neighbors:
- If a neighbor is **unvisited** → mark it visited, enqueue it with the current node as its parent.
- If a neighbor is **already visited** and is **not the parent** → a back edge exists, meaning a cycle is detected.

The outer `for` loop ensures disconnected components are also checked.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E) — each vertex and edge is processed once |
| **Space** | O(V + E) — adjacency list + visited array + BFS queue |

---

## Approach 2: DFS with Parent Tracking

Same parent-tracking idea but using **recursive DFS** instead of BFS. For each unvisited vertex, DFS passes the parent along every recursive call. If a visited neighbor is found that is not the parent, a cycle is detected and `true` is propagated back up the call stack immediately.

### Algorithm

1. Build an adjacency list from `edges`.
2. Initialize a `visited` boolean array of size `V`.
3. For each unvisited vertex `i`, call `dfs(i, -1, ...)`.
4. In the DFS helper:
   - Mark the current node as visited.
   - For each neighbor:
     - Unvisited → recurse; if recursion returns `true`, propagate it.
     - Visited and ≠ parent → **cycle found**, return `true`.
5. Return `false` if no cycle found in the component.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E) — each vertex and edge is processed once |
| **Space** | O(V + E) — adjacency list + visited array + recursion call stack |

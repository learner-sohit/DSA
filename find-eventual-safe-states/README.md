# 802. Find Eventual Safe States

[Link to Problem on LeetCode](https://leetcode.com/problems/find-eventual-safe-states/)

## Problem Description

A node in a directed graph is a **safe node** if every path starting from it eventually leads to a **terminal node** (a node with no outgoing edges) or another safe node.

Given a directed graph of `n` nodes (0-indexed) represented as an adjacency list `graph`, return all safe nodes in **sorted ascending order**.

### Example

**Input:**
```
graph = [[1,2],[2,3],[5],[0],[5],[],[]]
```

**Output:** `[2, 4, 5, 6]`

**Explanation:**
- Nodes 5 and 6 are terminal nodes (no outgoing edges) → safe.
- Node 2 leads only to node 5 → safe.
- Node 4 leads only to node 5 → safe.
- Nodes 0, 1, 3 are part of a cycle → unsafe.

---

## Approach: Reverse Graph + BFS (Kahn's Algorithm)

> **Key Insight:** A node is safe if it does **not** lie on a cycle or lead into one. Rather than detecting cycles directly, we **reverse all edges** and apply Kahn's Algorithm:
> - In the **original** graph, terminal nodes (out-degree 0) are trivially safe.
> - In the **reversed** graph, these terminals become source nodes (in-degree 0).
> - Running Kahn's BFS on the reversed graph "pulls in" all nodes that can reach a terminal in the original graph — those are exactly the safe nodes.
> - Nodes stuck with non-zero in-degree in the reversed graph are part of a cycle → unsafe.

### Algorithm

1. Build a **reversed adjacency list**: for each edge `u → v` in original, add `v → u`.
2. Track **in-degree** of each node in the original graph (i.e., original out-degree of `u`).
3. Enqueue all nodes with in-degree `0` in the reversed graph (= terminal nodes in original).
4. BFS (Kahn's): dequeue a node → add to answer → decrement in-degrees of its neighbors in reversed graph → enqueue any reaching `0`.
5. Sort and return the answer list.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E + V log V) — BFS is O(V + E), final sort is O(V log V) |
| **Space** | O(V + E) — reversed adjacency list + in-degree array + queue |

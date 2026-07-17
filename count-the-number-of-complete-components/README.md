# 2685. Count the Number of Complete Components

[Link to Problem on LeetCode](https://leetcode.com/problems/count-the-number-of-complete-components/)

## Problem Description

You are given an integer `n` (number of vertices labeled `0` to `n-1`) and a 2D integer array `edges` where `edges[i] = [a, b]` indicates an undirected edge between vertices `a` and `b`.

A connected component is **complete** if there is an edge between every pair of its vertices.

Return the number of **complete** connected components.

### Example

**Input:**
```
n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
```

**Output:** `3`

**Explanation:**
- Component `{0, 1, 2}` — 3 vertices, 3 edges = 3*(3-1)/2 → **complete**.
- Component `{3, 4}` — 2 vertices, 1 edge = 2*(2-1)/2 → **complete**.
- Component `{5}` — 1 vertex, 0 edges = 1*(1-1)/2 → **complete** (trivially).

---

## Approach 1: Brute Force — BFS + Pairwise Edge Check

Find each connected component via BFS, then verify completeness by checking whether every pair of vertices in the component shares a direct edge by scanning the edge list.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E + C² · E) — C = component size; pairwise check scans all edges |
| **Space** | O(V + E) — adjacency list + visited array |

---

## Approach 2: Optimal — BFS + Degree-Sum Formula

A connected component with `V` vertices is complete if and only if it has exactly `V*(V-1)/2` edges. During a single BFS pass, count the number of vertices and accumulate the degree of every node. Since each edge contributes to two degree counts, `totalEdges = degreeSum / 2`. Compare against the expected count.

### Algorithm

1. Build an adjacency list from `edges`.
2. Initialize a `visited` boolean array of size `n`.
3. For each unvisited vertex `i`, perform BFS:
   - Track `vertices` (count of nodes dequeued) and `degreeSum` (sum of neighbor counts).
   - After BFS, compute `totalEdges = degreeSum / 2` and `expected = vertices * (vertices - 1) / 2`.
   - If `totalEdges == expected`, increment `completeComponents`.
4. Return `completeComponents`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E) — single BFS pass, no pairwise checks needed |
| **Space** | O(V + E) — adjacency list + visited array + BFS queue |

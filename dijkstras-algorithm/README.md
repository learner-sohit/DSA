# Dijkstra's Algorithm

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1)

## Problem Description

Given a weighted **undirected** graph with `V` vertices and a list of edges `[u, v, wt]`, find the **shortest distance** from source node `src` to all other nodes.

Return `-1` for nodes that are unreachable from `src`.

### Example

**Input:**
```
V = 5, src = 0
edges = [[0,1,4],[0,2,1],[2,1,2],[1,3,1],[2,3,5],[3,4,3]]
```

**Output:** `[0, 3, 1, 4, 7]`

**Explanation:**
- `0 → 0` : 0
- `0 → 2 → 1` : 1 + 2 = 3
- `0 → 2` : 1
- `0 → 2 → 1 → 3` : 1 + 2 + 1 = 4
- `0 → 2 → 1 → 3 → 4` : 1 + 2 + 1 + 3 = 7

---

## Approach: Dijkstra's Algorithm (Min-Heap / Priority Queue)

> **Key Insight:** Dijkstra's is a greedy algorithm — always process the node with the **smallest known distance** first. This guarantees that the first time a node is popped from the min-heap, its distance is final (for non-negative weights).

> **Stale Entry Optimisation:** When a shorter path to a node is discovered, a new entry is pushed to the heap. The old (larger distance) entry becomes stale. Instead of removing it (expensive), we simply **skip it** with the check: `if (p.wt > dist[p.val]) continue`.

### Algorithm

1. Build an **undirected** weighted adjacency list from `edges`.
2. Initialize `dist[] = MAX_VALUE`; set `dist[src] = 0`.
3. Push `(src, 0)` into a **min-heap** (ordered by distance).
4. While heap is not empty:
   - Poll the node `p` with minimum distance.
   - **Skip** if `p.wt > dist[p.val]` (stale entry).
   - For each neighbor `nei`: if `dist[p.val] + nei.wt < dist[nei.val]` → update and push.
5. Replace any remaining `MAX_VALUE` with `-1` (unreachable).

### Complexity

| | Complexity |
|---|---|
| **Time** | O((V + E) log V) — each node and edge processed with heap operations |
| **Space** | O(V + E) — adjacency list + dist array + priority queue |

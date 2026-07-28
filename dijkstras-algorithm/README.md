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

## Approach 1: Dijkstra's Algorithm (TreeSet)

> **Key Insight:** A `TreeSet` ordered by `(weight, node)` acts as a self-balancing BST. Unlike a `PriorityQueue`, it supports **O(log N) removal of arbitrary entries** — so when a shorter path is found, the old stale entry is removed *immediately* before inserting the updated one. No lazy-skip check needed.

### Algorithm

1. Build an **undirected** weighted adjacency list.
2. Initialize `dist[] = MAX_VALUE`; set `dist[src] = 0`.
3. Add `(src, 0)` to `TreeSet` (ordered by weight, tie-broken by node index for uniqueness).
4. While set is not empty:
   - `pollFirst()` the minimum-distance node.
   - For each neighbor: if relaxation improves distance → **remove old entry**, update `dist`, **add new entry**.
5. Replace remaining `MAX_VALUE` with `-1`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O((V + E) log V) — each update does O(log V) TreeSet ops |
| **Space** | O(V + E) — adjacency list + dist array + TreeSet |

---

## Approach 2: Dijkstra's Algorithm (PriorityQueue / Min-Heap)

> Uses a min-heap. Stale entries are **not removed** — instead skipped lazily with: `if (p.wt > dist[p.val]) continue`. Simpler to implement but may hold more entries in the heap.

### Algorithm

1. Build adjacency list; initialize `dist[src] = 0`.
2. Push `(src, 0)` into a **min-heap**.
3. Poll minimum node; **skip if stale** (`p.wt > dist[p.val]`).
4. For each neighbor: if relaxation improves distance → update and push.
5. Replace `MAX_VALUE` with `-1`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O((V + E) log V) |
| **Space** | O(V + E) |

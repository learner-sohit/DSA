# Floyd-Warshall Algorithm

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1)

## Problem Description

Given a weighted directed graph of `n` vertices represented as an `n × n` distance matrix `dist[][]`, find the **shortest distance between every pair of vertices**.

- `dist[i][j]` = direct edge weight from `i` to `j`, or `1e8` (infinity) if no direct edge exists.
- `dist[i][i]` = 0 (distance from a node to itself).
- Modify the matrix **in-place**.

### Example

**Input:**
```
dist = [[0, 4, INF, 5],
        [INF, 0, 1, INF],
        [INF, INF, 0, 3],
        [INF, INF, INF, 0]]
```
**Output:**
```
[[0, 4, 5, 8],
 [INF, 0, 1, 4],
 [INF, INF, 0, 3],
 [INF, INF, INF, 0]]
```

---

## Approach: Floyd-Warshall (All-Pairs Shortest Path)

> **Key Insight:** For every pair `(i, j)`, try all possible **intermediate vertices `k`**. If going `i → k → j` is shorter than the current known path `i → j`, update `dist[i][j]`. After iterating over all `k`, the matrix contains the shortest path between every pair.
>
> The order matters — outer loop must be `k` (intermediate vertex), not `i` or `j`. This ensures that when `dist[i][j]` is updated via `k`, all paths through vertices `0..k-1` have already been considered.

### Algorithm

1. For each intermediate vertex `k` from `0` to `n-1`:
   - For each source `i` and destination `j`:
     - If `dist[i][k]` and `dist[k][j]` are not infinity:
       - `dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])`
2. After all iterations, `dist[i][j]` holds the shortest path between every pair.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V³) — three nested loops over all vertex pairs |
| **Space** | O(1) — in-place modification, no extra space needed |

### Comparison with Other Shortest Path Algorithms

| Algorithm | Handles Negative Weights | Detects Negative Cycles | Complexity | Use Case |
|---|---|---|---|---|
| **Floyd-Warshall** | ✅ | ✅ (diagonal becomes negative) | O(V³) | All-pairs shortest path |
| **Bellman-Ford** | ✅ | ✅ | O(V × E) | Single-source, sparse graph |
| **Dijkstra** | ❌ | ❌ | O((V+E) log V) | Single-source, non-negative weights |

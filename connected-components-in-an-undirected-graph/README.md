# Connected Components in an Undirected Graph

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/connected-components-in-an-undirected-graph/1)

## Problem Description

Given an undirected graph with `V` vertices (numbered `0` to `V-1`) and a list of edges, find all **connected components** of the graph. Return each component as a list of its vertices, and return all components together as a list of lists.

### Example

**Input:**
```
V = 6, edges = [[0,1],[1,2],[3,4]]
```

**Output:** `[[0, 1, 2], [3, 4], [5]]`

**Explanation:**
- Vertices 0, 1, and 2 are connected → one component.
- Vertices 3 and 4 are connected → one component.
- Vertex 5 has no edges → isolated component.

---

## Approach: BFS for Each Unvisited Node

Build an adjacency list from the given edge list. Then iterate over every vertex; whenever an unvisited vertex is found, launch a BFS from it to explore and collect all vertices reachable from it into a single component.

### Algorithm

1. Build an adjacency list of size `V` from the `edges` array.
2. Initialize a `visited` boolean array of size `V` (all `false`).
3. Iterate over every vertex `i` from `0` to `V-1`:
   - If `i` is not yet visited, start a BFS from `i`:
     - Mark `i` as visited, enqueue it.
     - While the queue is not empty, dequeue a node, add it to the current component, and enqueue all unvisited neighbors (marking them visited).
   - Add the completed component to the answer list.
4. Return the answer list.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E) — each vertex and edge is processed once |
| **Space** | O(V + E) — adjacency list + visited array + BFS queue |

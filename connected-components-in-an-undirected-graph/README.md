# Connected Components in an Undirected Graph

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/connected-components-in-an-undirected-graph/1)

## Problem Description

Given an undirected graph with `V` vertices (numbered `0` to `V-1`) and a list of edges, count the number of **connected components** in the graph.

### Example

**Input:**
```
V = 6, edges = [[0,1],[1,2],[3,4]]
```

**Output:** `3`

**Explanation:**
- Vertices 0, 1, and 2 are connected → one component.
- Vertices 3 and 4 are connected → one component.
- Vertex 5 has no edges → isolated component.
- Total connected components = 3.

---

## Approach 1: DFS for Each Unvisited Node

Build an adjacency list from the given edge list. Then iterate over every vertex; whenever an unvisited vertex is found, it means a new component has started. Increment the component count and use DFS to mark every vertex reachable from that starting vertex.

### Algorithm

1. Build an adjacency list of size `V` from the edge list.
2. Initialize a `visited` boolean array of size `V` (all `false`).
3. Iterate over every vertex `i` from `0` to `V-1`:
   - If `i` is not visited, increment `components`.
   - Start DFS from `i` and mark all reachable nodes as visited.
4. Return `components`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E) — each vertex and edge is processed once |
| **Space** | O(V + E) — adjacency list + visited array + recursion stack |

---

## Approach 2: BFS for Collecting Components

The previous repository solution used BFS to return the actual list of vertices in every component. It follows the same idea of starting a traversal from each unvisited node, but stores each traversed group in a separate list.

### Algorithm

1. Build the adjacency list from the edge array.
2. Iterate through all vertices.
3. For every unvisited vertex, start BFS using a queue.
4. Add every reached vertex to the current component list.
5. Add the completed component list to the answer.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E) |
| **Space** | O(V + E) |

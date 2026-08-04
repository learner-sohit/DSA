# 547. Number of Provinces

[Link to Problem on LeetCode](https://leetcode.com/problems/number-of-provinces/)

## Problem Description

There are `n` cities. Some of them are connected directly; others are not. If city `a` is connected to city `b`, and city `b` is connected to city `c`, then city `a` is connected to city `c`.

A **province** is a group of directly or indirectly connected cities with no other cities outside the group.

Given an `n x n` matrix `isConnected` where `isConnected[i][j] == 1` if city `i` and city `j` are directly connected and `isConnected[i][j] == 0` otherwise, return the total number of **provinces**.

### Example

**Input:**
```
isConnected = [[1,1,0],[1,1,0],[0,0,1]]
```

**Output:** `2`

**Explanation:** Cities 0 and 1 are connected, forming one province. City 2 is isolated, forming a second province.

---

## Approach 1: Union-Find

Treat every city as a separate set initially. For every `1` in the matrix, union the two corresponding cities. After processing the matrix, each distinct representative corresponds to one province.

### Algorithm

1. Initialize a disjoint-set structure with one set for each city.
2. Scan every matrix entry. For each `isConnected[i][j] == 1`, union cities `i` and `j` by size.
3. Count cities that are their own representative.
4. Return that count.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V² * alpha(V)) |
| **Space** | O(V) |

## Approach 2: DFS on Adjacency Matrix

The previous DFS approach treats the matrix directly as a graph. For every unvisited city, DFS marks all cities in the same connected component, which represents one province.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V²) |
| **Space** | O(V) |

# 207. Course Schedule

[Link to Problem on LeetCode](https://leetcode.com/problems/course-schedule/)

## Problem Description

There are `numCourses` courses labeled from `0` to `numCourses - 1`. You are given an array `prerequisites` where `prerequisites[i] = [a, b]` means you must take course `b` **before** course `a`.

Return `true` if you can finish all courses, `false` otherwise.

### Example

**Input:**
```
numCourses = 4, prerequisites = [[1,0],[2,1],[3,2],[1,3]]
```

**Output:** `false`

**Explanation:** Courses form a cycle: 1 → 2 → 3 → 1, so it's impossible to finish all courses.

**Input:**
```
numCourses = 2, prerequisites = [[1,0]]
```

**Output:** `true`

**Explanation:** Take course 0 first, then course 1.

---

## Approach: BFS — Kahn's Algorithm (Topological Sort)

> **Key Insight:** This problem is equivalent to **cycle detection in a directed graph**. Model each course as a node and each prerequisite pair `[a, b]` as a directed edge `b → a`. If the graph has no cycle (i.e., it's a DAG), all courses can be finished. Kahn's algorithm can process all nodes only in a DAG — if any nodes remain unprocessed, a cycle exists.

### Algorithm

1. Build a directed adjacency list: `prereq → course`.
2. Compute the **in-degree** for each course (number of prerequisites).
3. Enqueue all courses with in-degree `0` (no prerequisites needed).
4. BFS: dequeue a course, increment `completedCourses`, reduce in-degrees of its dependent courses, enqueue any that reach `0`.
5. Return `completedCourses == numCourses`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E) — V = numCourses, E = number of prerequisites |
| **Space** | O(V + E) — adjacency list + queue + in-degree array |

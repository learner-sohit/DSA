# 210. Course Schedule II

[Link to Problem on LeetCode](https://leetcode.com/problems/course-schedule-ii/)

## Problem Description

There are `numCourses` courses labeled from `0` to `numCourses - 1`. You are given an array `prerequisites` where `prerequisites[i] = [a, b]` means you must take course `b` **before** course `a`.

Return the ordering in which you should take courses to finish all of them. If it is impossible, return an **empty array**.

### Example 1

**Input:**
```
numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
```

**Output:** `[0, 1, 2, 3]` or `[0, 2, 1, 3]`

**Explanation:** Take 0 first, then 1 and 2 (in any order), then 3.

### Example 2

**Input:**
```
numCourses = 2, prerequisites = [[0,1],[1,0]]
```

**Output:** `[]`

**Explanation:** Courses 0 and 1 depend on each other — impossible to finish.

---

## Approach: BFS — Kahn's Algorithm (Topological Sort)

> **Key Insight:** This is an extension of [Course Schedule (207)](../course-schedule). Instead of just detecting a cycle, we also record the **topological order** in which nodes (courses) are processed. If we process all `numCourses` nodes, the recorded order is the answer. Otherwise, a cycle exists and we return `[]`.

### Algorithm

1. Build a directed adjacency list: `prereq → course`.
2. Compute the **in-degree** for each course.
3. Enqueue all courses with in-degree `0` (no prerequisites needed).
4. BFS: dequeue a course, add it to `order[]`, reduce in-degrees of its dependents, enqueue any that reach `0`.
5. Return `order` if `index == numCourses`, else return `[]`.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(V + E) — V = numCourses, E = number of prerequisites |
| **Space** | O(V + E) — adjacency list + queue + in-degree array |

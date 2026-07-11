# 23. Merge K Sorted Lists

**LeetCode Problem:** [https://leetcode.com/problems/merge-k-sorted-lists/](https://leetcode.com/problems/merge-k-sorted-lists/)

**Difficulty:** Hard

---

## Problem Description

You are given an array of `k` linked lists `lists`, each linked list is sorted in **ascending order**. Merge all the linked lists into **one sorted linked list** and return it.

---

## Examples

**Example 1:**

**Input:** `lists = [[1,4,5],[1,3,4],[2,6]]`  
**Output:** `[1,1,2,3,4,4,5,6]`  
**Explanation:** Merging the three sorted lists gives `1→1→2→3→4→4→5→6`.

---

**Example 2:**

**Input:** `lists = []`  
**Output:** `[]`

---

**Example 3:**

**Input:** `lists = [[]]`  
**Output:** `[]`

---

## Approaches

---

### Approach 3: Optimal — Min Heap (Priority Queue) (Active)

**Idea:**  
Use a Min Heap to always efficiently extract the globally smallest node across all `k` list heads. Seed the heap with the head of each non-null list. At each step, poll the minimum node, append it to the result, and push its successor (if any) back into the heap.

**Algorithm:**
1. Add the head of each non-null list to a `PriorityQueue` ordered by `val`.
2. While the heap is non-empty:
   - Poll the minimum node `temp`.
   - If `temp.next != null`, push `temp.next` into the heap.
   - Append `temp` to the result list.
3. Return `dummy.next`.

**Complexity:**
- **Time:** O(N log k) — N = total nodes, each node is pushed/popped once at O(log k) cost.
- **Space:** O(k) — at most `k` nodes in the heap at any time.

---

### Approach 2: Better — Sequential Merge (Merge One List at a Time)

**Idea:**  
Iteratively merge each list in `lists` into a running `head` using a standard two-list merge. Start with `head = null` and merge each list one by one. Each call to `mergeTwoLists` takes two sorted lists and produces one sorted result using a dummy node and two pointers.

**Complexity:**
- **Time:** O(k × n) — where `k` = number of lists, `n` = average list length. Each merge pass re-traverses all previously merged nodes.
- **Space:** O(1) — merging in-place with pointer manipulation.

---

### Approach 1: Brute Force — Collect, Sort, Rebuild

**Idea:**  
Traverse all `k` lists and collect every node value into an `ArrayList`. Sort the list, then build a brand new linked list from the sorted values.

**Algorithm:**
1. Iterate all lists, adding each node's value to `list`.
2. Sort `list` with `Collections.sort()`.
3. Build a new linked list by iterating the sorted values.
4. Return `dummy.next`.

**Complexity:**
- **Time:** O(N log N) — where N = total number of nodes across all lists.
- **Space:** O(N) — `ArrayList` stores all values + new nodes created for the result list.


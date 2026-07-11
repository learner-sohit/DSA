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

### Approach 2: Better — Sequential Merge One List at a Time (Active)

**Idea:**  
Iteratively merge each list in `lists` into a running `head` using a standard two-list merge. Start with `head = null` and merge each list one by one. Each call to `mergeTwoLists` takes two sorted lists and produces one sorted result using a dummy node and two pointers.

**`mergeTwoLists` Algorithm:**
1. Use a `dummy` node and a `curr` pointer.
2. While both lists are non-null: pick the smaller node, advance that pointer and `curr`.
3. Attach any remaining nodes from the non-exhausted list.
4. Return `dummy.next`.

**`mergeKLists` Algorithm:**
1. Initialize `head = null`.
2. For each list in `lists`: `head = mergeTwoLists(head, lists[i])`.
3. Return `head`.

**Complexity:**
- **Time:** O(k × n) — where `k` = number of lists, `n` = average list length. Each merge pass touches all previously merged nodes again.
- **Space:** O(1) — merging in-place with pointer manipulation (no extra nodes created).

> **Note:** A more optimal approach uses a **Min Heap (Priority Queue)** to always extract the globally smallest node across all lists in O(log k) time, giving O(N log k) total where N = total nodes. This is the optimal solution for large `k`.

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

# 21. Merge Two Sorted Lists

**LeetCode Problem:** [https://leetcode.com/problems/merge-two-sorted-lists/](https://leetcode.com/problems/merge-two-sorted-lists/)

**Difficulty:** Easy

---

## Problem Description

You are given the heads of two sorted linked lists `list1` and `list2`. Merge the two lists into one **sorted** list. The list should be made by **splicing together** the nodes of the first two lists.

Return the head of the merged linked list.

---

## Examples

**Example 1:**

**Input:** `list1 = [1,2,4]`, `list2 = [1,3,4]`  
**Output:** `[1,1,2,3,4,4]`

---

**Example 2:**

**Input:** `list1 = []`, `list2 = []`  
**Output:** `[]`

---

**Example 3:**

**Input:** `list1 = []`, `list2 = [0]`  
**Output:** `[0]`

---

## Approach

---

### Approach 1: Optimal — Iterative Two Pointer with Dummy Node

**Idea:**  
Use a `dummy` sentinel node to avoid special-casing the head of the result. Maintain a `curr` pointer on the result list. At each step, compare the front nodes of both lists and attach the smaller one to `curr`, then advance that list's pointer. After one list is exhausted, attach the remaining nodes of the other directly.

**Algorithm:**
1. Create `dummy = new ListNode(-1)`, `curr = dummy`.
2. While both `list1` and `list2` are non-null:
   - If `list1.val <= list2.val`: attach `list1`, advance `list1`.
   - Else: attach `list2`, advance `list2`.
   - Advance `curr`.
3. Attach remaining nodes from whichever list is non-null.
4. Return `dummy.next`.

**Why a dummy node?**  
It eliminates the need to special-case setting the head of the result — `dummy.next` always points to the merged list's head regardless of which list contributes the first node.

**Complexity:**
- **Time:** O(n + m) — each node is visited exactly once, where `n` and `m` are the lengths of the two lists.
- **Space:** O(1) — no new nodes created; existing nodes are re-linked in place.

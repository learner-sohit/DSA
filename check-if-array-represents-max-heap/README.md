# Check if an Array Represents a Max Heap

**GeeksforGeeks Problem:** [https://www.geeksforgeeks.org/problems/is-binary-tree-heap/1](https://www.geeksforgeeks.org/problems/is-binary-tree-heap/1)

**Difficulty:** Easy

---

## Problem Description

Given an array `arr[]` of size `n`, check whether the given array represents a **Max Heap** or not.

In a Max Heap stored as an array (0-indexed):
- Parent of node at index `i` → `(i - 1) / 2`
- Left child of node at index `i` → `2 * i + 1`
- Right child of node at index `i` → `2 * i + 2`
- Every **parent must be greater than or equal to both its children**.
- Internal nodes (nodes that have at least one child) are at indices `0` to `size/2 - 1`.

---

## Examples

**Example 1:**

**Input:** `arr = [90, 15, 10, 7, 12, 2]`  
**Output:** `true`  
**Explanation:** Every parent is greater than its children. Valid max heap.

---

**Example 2:**

**Input:** `arr = [9, 3, 2, 4, 8]`  
**Output:** `false`  
**Explanation:** Node at index 1 (value 3) has a right child at index 4 (value 8). Since 3 < 8, the max heap property is violated.

---

## Approach

---

### Approach 1: Check All Internal Nodes Against Children

**Idea:**  
Only internal nodes (indices `0` to `size/2 - 1`) have children. Leaf nodes never need to be checked as parents. For each internal node, verify that both existing children have values less than or equal to the parent. If any child is greater, return `false`. If all pass, return `true`.

**Algorithm:**
1. Iterate `i` from `0` to `size/2 - 1`.
2. Compute `left = 2*i + 1` and `right = 2*i + 2`.
3. If `left < size` and `arr[i] < arr[left]` → return `false`.
4. If `right < size` and `arr[i] < arr[right]` → return `false`.
5. Return `true`.

**Why only up to `size/2`?**  
In a 0-indexed array representing a complete binary tree, the first leaf node is always at index `size/2`. All nodes from index `size/2` onwards are leaves with no children, so they never violate the heap property as parents.

**Complexity:**
- **Time:** O(n) — visits each internal node once.
- **Space:** O(1) — no extra space used.

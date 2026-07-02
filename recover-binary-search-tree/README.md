# 99. Recover Binary Search Tree

**LeetCode Problem:** [https://leetcode.com/problems/recover-binary-search-tree/](https://leetcode.com/problems/recover-binary-search-tree/)

**Difficulty:** Medium

---

## Problem Description

You are given the `root` of a binary search tree (BST), where the values of **exactly two** nodes have been swapped by mistake. Recover the tree without changing its structure.

---

## Examples

**Example 1:**
```
    1              3
     \      →     / \
      3           1    (fixed)
     /
    2 (should be root)
```
**Input:** `root = [1,3,null,null,2]`  
**Output:** `[3,1,2]`

---

**Example 2:**
```
      3                 2
     / \       →       / \
    1   4             1   4
       /                 /
      2                 3
```
**Input:** `root = [3,1,4,null,null,2]`  
**Output:** `[2,1,4,null,null,3]`

---

## Approach

---

### Approach 1: Inorder + Sort + Reassign

**Idea:**  
The inorder traversal of a valid BST produces values in strictly ascending order. Since exactly two nodes are swapped, the inorder traversal of the broken BST will contain the same values but in a wrong order. By sorting the collected inorder values and reassigning them back to the tree nodes in inorder order, the BST is recovered.

**Algorithm:**
1. Perform an inorder traversal of the tree and collect all node values into `list`.
2. Sort `list` to get the correct order of values.
3. Traverse the tree again in inorder using a global `idx` pointer; at each node, assign `list.get(idx++)` to restore the correct value.

**Complexity:**
- **Time:** O(n log n) — O(n) for traversal + O(n log n) for sorting.
- **Space:** O(n) — list stores all node values.

---

> **Note:** A more space-efficient approach (O(1) extra space) exists using **Morris Traversal** or by tracking the two misplaced nodes directly during a single inorder pass using `prev`, `first`, and `second` pointers — and then swapping only those two node values. This avoids sorting and re-traversal entirely (O(n) time, O(h) or O(1) space).

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
    2
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

## Approaches

---

### Approach 2: Optimal — Single Inorder Pass (Active)

**Idea:**  
The inorder traversal of a valid BST is strictly ascending. Exactly two nodes are swapped, which causes at most **two violations** (places where `prev.val > curr.val`) during inorder traversal:
- If there are **two violations**: the `first` swapped node is `prev` at the first violation, and the `last` swapped node is `curr` at the second violation.
- If there is **only one violation** (adjacent nodes swapped): the swapped pair is `first` (prev at violation) and `middle` (curr at violation).

After traversal, swap the values of the identified pair to recover the BST.

**Algorithm:**
1. Initialize `prev` to a dummy node with `Integer.MIN_VALUE`.
2. Traverse inorder. At each step, if `prev.val > root.val`:
   - First violation: set `first = prev`, `middle = root`.
   - Second violation: set `last = root`.
3. After traversal:
   - If `first` and `last` are both set → swap their values.
   - Else → swap `first` and `middle` values (adjacent swap case).

**Complexity:**
- **Time:** O(n) — single inorder traversal.
- **Space:** O(h) — recursion call stack (O(log n) balanced, O(n) worst case).

---

### Approach 1: Brute Force — Inorder + Sort + Reassign

**Idea:**  
Perform a full inorder traversal to collect all node values into a list. Sort the list to get the correct order, then traverse the tree again inorder and reassign values from the sorted list back to each node.

**Algorithm:**
1. Traverse the BST inorder and collect values into `list`.
2. Sort `list`.
3. Traverse inorder again using an `idx` counter; assign `list.get(idx++)` to each node, fixing any mismatches.

**Complexity:**
- **Time:** O(n log n) — O(n) traversal + O(n log n) sort.
- **Space:** O(n) — list stores all node values.

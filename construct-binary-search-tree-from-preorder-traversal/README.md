# 1008. Construct Binary Search Tree from Preorder Traversal

**LeetCode Problem:** [https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/](https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/)

**Difficulty:** Medium

---

## Problem Description

Given an array of integers `preorder`, which represents the **preorder traversal** of a BST, construct the tree and return its root.

It is **guaranteed** that there is always possible to find a binary search tree with the given requirements for the given test cases.

---

## Examples

**Example 1:**
```
        8
       / \
      5   10
     / \    \
    1   7    12
```
**Input:** `preorder = [8,5,1,7,10,12]`  
**Output:** `[8,5,10,1,7,null,12]`

---

**Example 2:**

**Input:** `preorder = [1,3]`  
**Output:** `[1,null,3]`

---

## Approaches

---

### Approach 1: Recursive with Bound (Optimal)

**Idea:**  
Use a global `index` pointer that advances as nodes are consumed from the preorder array. Pass a `bound` value down the recursion — any value exceeding the bound belongs to an ancestor's right subtree, not the current one. This avoids re-scanning elements and builds the tree in a single O(n) pass.

**Algorithm:**
1. If `index == preorder.length` or `preorder[index] > bound`, return `null`.
2. Create a node with `preorder[index++]`.
3. Recurse left with `bound = root.val` (left children must be smaller than root).
4. Recurse right with the same `bound` inherited from the parent.
5. Return the constructed node.

**Complexity:**
- **Time:** O(n) — each element is visited exactly once.
- **Space:** O(h) — recursion call stack, where `h` is the tree height.

---

### Approach 2: Brute Force — Iterative Insert

**Idea:**  
Treat the first element of preorder as the root, then iteratively insert the remaining elements one by one into the BST using standard BST insertion logic.

**Algorithm:**
1. Create root from `preorder[0]`.
2. For each subsequent value, traverse the tree from the root: go left if the value is smaller, go right if larger, and insert when `null` is reached.

**Complexity:**
- **Time:** O(n²) worst case (skewed tree), O(n log n) average.
- **Space:** O(n) — the constructed tree itself.

---

### Approach 3: Brute Force — Recursive Insert

**Idea:**  
Same as Approach 2, but uses a recursive helper to insert each value into the BST instead of an iterative loop.

**Algorithm:**
1. Start with `root = null`.
2. For each value in preorder, call `insert(root, val)` recursively.
3. In `insert`: if `root == null`, create and return a new node; otherwise recurse left or right based on comparison.

**Complexity:**
- **Time:** O(n²) worst case (skewed tree), O(n log n) average.
- **Space:** O(n) — tree storage + O(h) recursion stack.

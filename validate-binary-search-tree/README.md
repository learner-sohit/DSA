# 98. Validate Binary Search Tree

**LeetCode Problem:** [https://leetcode.com/problems/validate-binary-search-tree/](https://leetcode.com/problems/validate-binary-search-tree/)

**Difficulty:** Medium

---

## Problem Description

Given the `root` of a binary tree, determine if it is a valid binary search tree (BST).

A **valid BST** is defined as follows:
- The left subtree of a node contains only nodes with keys **less than** the node's key.
- The right subtree of a node contains only nodes with keys **greater than** the node's key.
- Both the left and right subtrees must also be binary search trees.

---

## Examples

**Example 1:**
```
    2
   / \
  1   3
```
**Input:** `root = [2,1,3]`  
**Output:** `true`

---

**Example 2:**
```
    5
   / \
  1   4
     / \
    3   6
```
**Input:** `root = [5,1,4,null,null,3,6]`  
**Output:** `false`  
**Explanation:** The root node's value is `5`, but its right child's value is `4`.

---

## Approaches

---

### Approach 1: Inorder Traversal (Recursive with `prev` pointer)

**Idea:**  
An inorder traversal of a valid BST always produces values in strictly increasing order. We keep a `prev` pointer to track the previously visited node. If at any point the current node's value is not greater than `prev.val`, it's not a valid BST.

**Algorithm:**
1. Recursively traverse the left subtree.
2. Compare the current node's value with `prev`. If `prev.val >= current.val`, return `false`.
3. Update `prev` to the current node.
4. Recursively traverse the right subtree.

**Complexity:**
- **Time:** O(n) — each node is visited once.
- **Space:** O(h) — recursion stack where `h` is the tree height (O(log n) balanced, O(n) worst case).

---

### Approach 2: Morris Traversal (Inorder, O(1) Space)

**Idea:**  
Morris Traversal performs an inorder traversal without using the recursion stack or an explicit stack, achieving O(1) extra space. It temporarily modifies the tree by threading right pointers from the inorder predecessor back to the current node, then restores the tree structure before moving on.

**Algorithm:**
1. Start with `curr = root`, `prev = null`.
2. If `curr.left == null`: check order against `prev`, update `prev`, move right.
3. Otherwise: find the inorder predecessor (`pred`) of `curr` in its left subtree.
   - If `pred.right == null`: thread it to `curr`, move left.
   - If `pred.right == curr`: unthread, check order against `prev`, update `prev`, move right.

**Complexity:**
- **Time:** O(n) — each node is visited at most twice.
- **Space:** O(1) — no extra stack or recursion.

---

### Approach 3: Recursive Range (Min/Max Bounds)

**Idea:**  
Pass a valid range `(min, max)` down the recursion. Each node's value must strictly fall within its inherited range. For the left subtree, the upper bound becomes the current node's value; for the right subtree, the lower bound becomes the current node's value.

**Algorithm:**
1. Start with `helper(root, Long.MIN_VALUE, Long.MAX_VALUE)`.
2. If `root == null`, return `true`.
3. If `root.val <= min || root.val >= max`, return `false`.
4. Recurse: `helper(left, min, root.val)` AND `helper(right, root.val, max)`.

**Complexity:**
- **Time:** O(n) — each node is visited once.
- **Space:** O(h) — recursion stack where `h` is the tree height.

# 235. Lowest Common Ancestor of a Binary Search Tree

**LeetCode Problem:** [https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

**Difficulty:** Medium

---

## Problem Description

Given a binary search tree (BST), find the **lowest common ancestor (LCA)** node of two given nodes `p` and `q` in the BST.

The lowest common ancestor is defined as: "The lowest node in the tree that has both `p` and `q` as descendants (where we allow **a node to be a descendant of itself**)."

---

## Examples

**Example 1:**
```
        6
       / \
      2   8
     / \ / \
    0  4 7  9
      / \
     3   5
```
**Input:** `root = [6,2,8,0,4,7,9,null,null,3,5]`, `p = 2`, `q = 8`  
**Output:** `6`  
**Explanation:** The LCA of nodes `2` and `8` is `6`.

---

**Example 2:**
```
        6
       / \
      2   8
     / \ / \
    0  4 7  9
      / \
     3   5
```
**Input:** `root = [6,2,8,0,4,7,9,null,null,3,5]`, `p = 2`, `q = 4`  
**Output:** `2`  
**Explanation:** The LCA of nodes `2` and `4` is `2`, since a node can be a descendant of itself.

---

## Approaches

---

### Approach 1: Iterative

**Idea:**  
Exploit the BST property. If both `p` and `q` are greater than the current node, the LCA must be in the right subtree. If both are smaller, it's in the left subtree. Otherwise, the current node is the split point — it is the LCA.

**Algorithm:**
1. Start at `root`.
2. If `root.val < p.val && root.val < q.val` → move right.
3. If `root.val > p.val && root.val > q.val` → move left.
4. Otherwise → `root` is the LCA, return it.

**Complexity:**
- **Time:** O(h) — where `h` is the height of the tree (O(log n) balanced, O(n) worst case).
- **Space:** O(1) — no extra space used.

---

### Approach 2: Recursive

**Idea:**  
Same logic as the iterative approach, but expressed recursively. The BST property guides us to the correct subtree at each step.

**Algorithm:**
1. If `root == null`, return `null`.
2. If both `p` and `q` are greater than `root.val` → recurse right.
3. If both `p` and `q` are smaller than `root.val` → recurse left.
4. Otherwise → return `root` as the LCA.

**Complexity:**
- **Time:** O(h) — where `h` is the height of the tree.
- **Space:** O(h) — recursion call stack.

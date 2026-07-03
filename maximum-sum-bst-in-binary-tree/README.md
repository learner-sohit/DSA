# 1373. Maximum Sum BST in Binary Tree

**LeetCode Problem:** [https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/](https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/)

**Difficulty:** Hard

---

## Problem Description

Given a **binary tree** `root`, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree.

It is guaranteed that there is at least one sub-tree that is a BST. A single node with no children is also a valid BST.

---

## Examples

**Example 1:**
```
        1
       / \
      4   3
     / \ / \
    2  4 2  5
          / \
         4   6
```
**Input:** `root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]`  
**Output:** `20`  
**Explanation:** Maximum sum BST is the subtree rooted at node `3` with values `[3,2,5,4,6]`, sum = `3+2+5+4+6 = 20`.

---

**Example 2:**

**Input:** `root = [4,3,null,1,2]`  
**Output:** `2`  
**Explanation:** Maximum sum BST is the single-node subtree with value `2`.

---

**Example 3:**

**Input:** `root = [-4,-2,-5]`  
**Output:** `0`  
**Explanation:** All values are negative; an empty subtree (sum = 0) is returned.

---

## Approaches

---

### Approach 2: Optimal — Single Post-order Pass with `NodeInfo` (Active)

**Idea:**  
Instead of re-checking BST validity and re-computing sums independently for each node (brute force), propagate all necessary information — `isBST`, `min`, `max`, `sum` — upward in a single post-order traversal. At each node, determine if the current subtree is a valid BST using the reported `max` of the left child and `min` of the right child, then update the global answer.

**`NodeInfo` fields:**
- `isBST`: whether the subtree rooted here is a valid BST.
- `min`: minimum value in this subtree (used by parent to validate BST property on the right side).
- `max`: maximum value in this subtree (used by parent to validate BST property on the left side).
- `sum`: sum of all values in this subtree.

**Base case (null node):** `isBST = true`, `min = Integer.MAX_VALUE`, `max = Integer.MIN_VALUE`, `sum = 0`. Using extreme sentinel values ensures they don't incorrectly constrain any parent.

**Algorithm:**
1. Post-order: recurse left and right, collecting `NodeInfo` from each.
2. If both subtrees are BSTs AND `left.max < root.val < right.min`:
   - Compute `sum = root.val + left.sum + right.sum`.
   - Update global `ans = max(ans, sum)`.
   - Return `NodeInfo(true, min(root.val, left.min), max(root.val, right.max), sum)`.
3. Otherwise, return `NodeInfo(false, 0, 0, 0)` — subtree is not a BST, propagation stops here.

**Complexity:**
- **Time:** O(n) — each node is visited exactly once.
- **Space:** O(h) — recursion call stack.

---

### Approach 1: Brute Force — Check BST + Sum at Every Node

**Idea:**  
Visit every node in the tree. For each node, check if its subtree is a valid BST using a recursive range-check, and if so, compute the subtree sum. Track the maximum sum seen across all valid BST subtrees.

**Algorithm:**
1. For each node, call `isBST(root, MIN, MAX)` to check BST validity.
2. If valid, call `getSum(root)` to compute the subtree sum.
3. Update `ans` with the maximum sum found.
4. Recurse on both children to check all subtrees.

**Complexity:**
- **Time:** O(n²) — for each of the n nodes, BST check and sum computation can take O(n).
- **Space:** O(h) — recursion stack.

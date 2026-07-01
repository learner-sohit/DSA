# 653. Two Sum IV - Input is a BST

**LeetCode Problem:** [https://leetcode.com/problems/two-sum-iv-input-is-a-bst/](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/)

**Difficulty:** Easy

---

## Problem Description

Given the `root` of a binary search tree and an integer `k`, return `true` if there exist **two elements** in the BST such that their sum is equal to `k`, or `false` otherwise.

---

## Examples

**Example 1:**
```
        5
       / \
      3   6
     / \    \
    2   4    7
```
**Input:** `root = [5,3,6,2,4,null,7]`, `k = 9`  
**Output:** `true`

---

**Example 2:**

**Input:** `root = [5,3,6,2,4,null,7]`, `k = 28`  
**Output:** `false`

---

## Approaches

---

### Approach 2: Two BST Iterators (Two-Pointer, Optimal)

**Idea:**  
Use two custom `BSTIterator` instances — one that traverses the BST in **inorder (ascending)** and one in **reverse inorder (descending)**. These act as a left pointer and a right pointer respectively, just like a two-pointer approach on a sorted array, but without materializing the full list. Each iterator uses a stack and pushes left (or right) spine nodes lazily.

**Algorithm:**
1. Initialize `left` iterator (ascending) and `right` iterator (descending).
2. Fetch `i = left.next()` (smallest) and `j = right.next()` (largest).
3. While `i < j`:
   - If `i + j == k` → return `true`.
   - If `i + j > k` → advance `right` (decrease `j`).
   - If `i + j < k` → advance `left` (increase `i`).
4. Return `false` if no pair found.

**`BSTIterator` details:**
- Constructor pushes all leftmost (or rightmost for reverse) nodes onto the stack.
- `next()` pops the top, then pushes the right (or left for reverse) subtree's spine.
- `hasNext()` checks if the stack is non-empty.

**Complexity:**
- **Time:** O(n) — each node is visited at most once across all `next()` calls.
- **Space:** O(h) — only the current path spine is stored on the stack.

---

### Approach 1: Inorder List + Two Pointers

**Idea:**  
Perform a full inorder traversal to collect all node values in a sorted list. Then apply the classic two-pointer technique on the sorted array to find the target sum.

**Algorithm:**
1. Traverse the BST inorder and collect values into `list`.
2. Use two pointers `i = 0` and `j = list.size() - 1`.
3. While `i < j`:
   - If `list[i] + list[j] == k` → return `true`.
   - If sum > k → decrement `j`.
   - If sum < k → increment `i`.
4. Return `false`.

**Complexity:**
- **Time:** O(n) — traversal + two-pointer scan.
- **Space:** O(n) — list stores all node values.

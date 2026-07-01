# 173. Binary Search Tree Iterator

**LeetCode Problem:** [https://leetcode.com/problems/binary-search-tree-iterator/](https://leetcode.com/problems/binary-search-tree-iterator/)

**Difficulty:** Medium

---

## Problem Description

Implement the `BSTIterator` class that represents an iterator over the **in-order traversal** of a binary search tree (BST):

- `BSTIterator(TreeNode root)` — Initializes an object of the `BSTIterator` class. The `root` of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
- `boolean hasNext()` — Returns `true` if there exists a number in the traversal to the right of the pointer, otherwise returns `false`.
- `int next()` — Moves the pointer to the right, then returns the number at the pointer.

Notice that by initializing the pointer to a non-existent smallest number, the first call to `next()` will return the smallest element in the BST.

You may assume that `next()` calls will always be valid, i.e., there will be at least a next number in the in-order traversal when `next()` is called.

---

## Examples

**Example 1:**
```
        7
       / \
      3   15
         /  \
        9    20
```
**Input:**
```
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
```
**Output:**
```
[null, 3, 7, true, 9, true, 15, true, 20, false]
```

---

## Approaches

---

### Method 2: Precomputed Inorder List (Active)

**Idea:**  
Perform a full inorder traversal of the BST in the constructor and store all values in a list. Use an index pointer to track the current position for `next()` and `hasNext()`.

**Algorithm:**
1. In the constructor, recursively traverse the tree (left → root → right) and collect all values into `list`.
2. `next()`: return `list.get(idx++)`.
3. `hasNext()`: return `idx < list.size()`.

**Complexity:**
- **Time:** O(n) constructor | O(1) `next()` and `hasNext()`.
- **Space:** O(n) — stores all node values upfront.

---

### Method 1: Controlled Iteration using Stack (Space-Optimal)

**Idea:**  
Instead of precomputing the entire traversal, simulate inorder traversal lazily using a stack. Push all leftmost nodes from any given node onto the stack. When `next()` is called, pop the top node (smallest unvisited), then push all leftmost nodes of its right subtree.

**Algorithm:**
1. In the constructor, call `pushAll(root)` to push all left nodes from root.
2. `next()`: pop the top of the stack, call `pushAll(node.right)`, return `node.val`.
3. `hasNext()`: return `!stack.isEmpty()`.

**Complexity:**
- **Time:** O(1) amortized for `next()` — each node is pushed and popped exactly once over all calls.
- **Space:** O(h) — at most `h` nodes on the stack at any time, where `h` is the tree height (O(log n) balanced, O(n) worst case).

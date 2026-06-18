# 545. Boundary of Binary Tree

[Link to Problem on LeetCode](https://leetcode.com/problems/boundary-of-binary-tree/)

## Problem Description

The **boundary** of a binary tree is the concatenation of the **root**, the **left boundary**, the **leaves** ordered from left-to-right, and the **reverse** of the **right boundary**.

Return _the boundary of the binary tree_.

### Example

**Input:** `root = [1,null,2,3,4]`  
**Output:** `[1,3,4,2]`

**Explanation:**
- The left boundary is empty because there is no left child.
- The leaves are `[3,4]`.
- The right boundary in reverse order is `[2]`.
- Concatenating them gives `[1] + [] + [3,4] + [2] = [1,3,4,2]`.

## Explanation

### Three-Part Boundary Traversal

The boundary is built in four stages: root, left boundary, leaves, and right boundary (in reverse).

1. **Base Cases**:
   - If `root` is null, return an empty list.
   - If `root` is a leaf, return only `[root.val]`.

2. **Root**:
   - Add the root value first.

3. **Left Boundary** (`addLeftBoundary`):
   - Traverse from `root.left` downward.
   - Prefer going left; if left is missing, go right.
   - Add node values only when the node is **not** a leaf.

4. **Leaves** (`addLeaves`):
   - Recursively traverse the tree in left-to-right order.
   - Add values only for leaf nodes.

5. **Right Boundary** (`addRightBoundary`):
   - Traverse from `root.right` downward.
   - Prefer going right; if right is missing, go left.
   - Push non-leaf values onto a stack while traversing.
   - Pop from the stack to append them in bottom-to-top order.

- **Time Complexity:** O(N), where N is the number of nodes. Each node is visited a constant number of times.
- **Space Complexity:** O(H), where H is the height of the tree, for recursion on leaves and the stack used for the right boundary.

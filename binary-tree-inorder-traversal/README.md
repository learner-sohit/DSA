# 94. Binary Tree Inorder Traversal

[Link to Problem on LeetCode](https://leetcode.com/problems/binary-tree-inorder-traversal/)

## Problem Description

Given the `root` of a binary tree, return _the inorder traversal of its nodes' values_.

### Example

**Input:** `root = [1,null,2,3]`
**Output:** `[1,3,2]`

## Explanation

The solution uses a standard recursive approach for a depth-first search (DFS).

### Recursive Inorder Traversal

In an inorder traversal, the nodes are visited in the following order:

1.  **Left:** Traverse the left subtree.
2.  **Root:** Visit the current node.
3.  **Right:** Traverse the right subtree.

The algorithm works as follows:

1.  A main function `inorderTraversal` initializes an empty `result` array.
2.  It calls a helper recursive function `inOrder` passing the `root` and the `result` array.
3.  Inside the `inOrder` helper function:
    - **Base Case:** If the `root` is null (empty node), return immediately.
    - **Left:** Recursively call `inOrder` on `root.left`. The check `if(root.left)` is an optimization to avoid an unnecessary recursive call if the left child doesn't exist.
    - **Root:** Push the current `root.val` into the `result` array.
    - **Right:** Recursively call `inOrder` on `root.right`. Similar optimization is applied here.
4.  Once all recursive calls resolve, the `result` array containing the inorder traversal is returned by the main function.

- **Time Complexity:** O(N) where N is the number of nodes in the binary tree. We visit each node exactly once.
- **Space Complexity:** O(H) where H is the height of the tree. This is the space required for the call stack during recursion. In the worst case (a skewed tree), the space complexity is O(N). In the best case (a perfectly balanced tree), it's O(log N). The `result` array also takes O(N) space, but this is typically not counted towards auxiliary space complexity as it's required for the output format.

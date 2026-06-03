# 145. Binary Tree Postorder Traversal

[Link to Problem on LeetCode](https://leetcode.com/problems/binary-tree-postorder-traversal/)

## Problem Description

Given the `root` of a binary tree, return _the postorder traversal of its nodes' values_.

### Example

**Input:** `root = [1,null,2,3]`
**Output:** `[3,2,1]`

## Explanation

The solution uses a standard recursive approach for a depth-first search (DFS).

### Recursive Postorder Traversal

In a postorder traversal, the nodes are visited in the following order:

1.  **Left:** Traverse the left subtree.
2.  **Right:** Traverse the right subtree.
3.  **Root:** Visit the current node.

The algorithm works as follows:

1.  A main function `postorderTraversal` initializes an empty `result` array.
2.  It calls a helper recursive function `postOrder` passing the `root` and the `result` array.
3.  Inside the `postOrder` helper function:
    - **Base Case:** If the `root` is null (empty node), return immediately.
    - **Left:** Recursively call `postOrder` on `root.left`. The check `if(root.left)` is an optimization to avoid an unnecessary recursive call if the left child doesn't exist.
    - **Right:** Recursively call `postOrder` on `root.right`. Similar optimization is applied here.
    - **Root:** Push the current `root.val` into the `result` array.
4.  Once all recursive calls resolve, the `result` array containing the postorder traversal is returned by the main function.

- **Time Complexity:** O(N) where N is the number of nodes in the binary tree. We visit each node exactly once.
- **Space Complexity:** O(H) where H is the height of the tree. This is the space required for the call stack during recursion. In the worst case (a skewed tree), the space complexity is O(N). In the best case (a perfectly balanced tree), it's O(log N). The `result` array also takes O(N) space.

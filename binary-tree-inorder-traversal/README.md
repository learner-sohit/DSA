# 94. Binary Tree Inorder Traversal

[Link to Problem on LeetCode](https://leetcode.com/problems/binary-tree-inorder-traversal/)

## Problem Description

Given the `root` of a binary tree, return _the inorder traversal of its nodes' values_.

### Example

**Input:** `root = [1,null,2,3]`
**Output:** `[1,3,2]`

## Explanation

The solution file contains both iterative and recursive approaches for inorder traversal.

### Iterative Inorder Traversal

In an inorder traversal, the nodes are visited in this order:

1.  **Left:** Traverse the left subtree.
2.  **Root:** Visit the current node.
3.  **Right:** Traverse the right subtree.

The iterative solution uses a stack to simulate the recursive call stack.

1.  If the `root` is null, return an empty array.
2.  Create a `result` array, a `stack`, and set `curr` to `root`.
3.  Continue while `curr` exists or the stack is not empty.
4.  Move as far left as possible:
    - Push each current node into the stack.
    - Move `curr` to `curr.left`.
5.  When there is no more left child, pop a node from the stack.
6.  Add the popped node's value to `result`.
7.  Move to the popped node's right child.
8.  Once the loop ends, return `result`.

- **Time Complexity:** O(N) where N is the number of nodes in the binary tree.
- **Space Complexity:** O(H) where H is the height of the tree. In the worst case, this can be O(N).

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
- **Space Complexity:** O(H) where H is the height of the tree. This is the space required for the call stack during recursion. In the worst case (a skewed tree), the space complexity is O(N). In the best case (a perfectly balanced tree), it's O(log N).

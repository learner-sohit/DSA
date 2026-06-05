# 145. Binary Tree Postorder Traversal

[Link to Problem on LeetCode](https://leetcode.com/problems/binary-tree-postorder-traversal/)

## Problem Description

Given the `root` of a binary tree, return _the postorder traversal of its nodes' values_.

### Example

**Input:** `root = [1,null,2,3]`
**Output:** `[3,2,1]`

## Explanation

The solution file contains iterative and recursive approaches for postorder traversal.

### Iterative Postorder Traversal Using 1 Stack

In a postorder traversal, the nodes are visited in this order:

1.  **Left:** Traverse the left subtree.
2.  **Right:** Traverse the right subtree.
3.  **Root:** Visit the current node.

The one-stack iterative solution simulates recursion by moving left first, then deciding whether the current node's right subtree still needs to be processed.

1.  Create a `result` array, a `stack`, and set `curr` to `root`.
2.  Continue while `curr` exists or the stack is not empty.
3.  Move as far left as possible:
    - Push each current node into the stack.
    - Move `curr` to `curr.left`.
4.  Check the right child of the node at the top of the stack.
5.  If there is no right child, pop the node and add its value to `result`.
6.  Keep popping while the last processed node was the right child of the new stack top.
7.  If a right child exists and has not been processed, move `curr` to that right child.
8.  Return `result` after all nodes are processed.

- **Time Complexity:** O(N) where N is the number of nodes in the binary tree.
- **Space Complexity:** O(H) where H is the height of the tree. In the worst case, this can be O(N).

### Iterative Postorder Traversal Using 2 Stacks

This approach uses two stacks to reverse a Root-Right-Left traversal into Left-Right-Root.

1.  If the `root` is null, return an empty array.
2.  Push the `root` into the first stack.
3.  Pop nodes from the first stack and push their values into the second stack.
4.  Push the left child first and the right child second into the first stack.
5.  Once the first stack is empty, pop all values from the second stack into `result`.
6.  Return `result`.

- **Time Complexity:** O(N)
- **Space Complexity:** O(N)

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
- **Space Complexity:** O(H) where H is the height of the tree. This is the space required for the call stack during recursion. In the worst case (a skewed tree), the space complexity is O(N). In the best case (a perfectly balanced tree), it's O(log N).

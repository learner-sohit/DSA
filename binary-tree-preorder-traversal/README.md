# 144. Binary Tree Preorder Traversal

[Link to Problem on LeetCode](https://leetcode.com/problems/binary-tree-preorder-traversal/)

## Problem Description

Given the `root` of a binary tree, return _the preorder traversal of its nodes' values_.

### Example

**Input:** `root = [1,null,2,3]`
**Output:** `[1,2,3]`

## Explanation

The solution uses a standard recursive approach for a depth-first search (DFS).

### Recursive Preorder Traversal

In a preorder traversal, the nodes are visited in the following order:

1.  **Root:** Visit the current node.
2.  **Left:** Traverse the left subtree.
3.  **Right:** Traverse the right subtree.

The algorithm works as follows:

1.  A main function `preorderTraversal` initializes an empty `result` array.
2.  It calls a helper recursive function `preOrder` passing the `root` and the `result` array.
3.  Inside the `preOrder` helper function:
    - **Base Case:** If the `root` is null (empty node), return immediately.
    - **Root:** Push the current `root.val` into the `result` array.
    - **Left:** Recursively call `preOrder` on `root.left`. The check `if(root.left)` is an optimization to avoid an unnecessary recursive call if the left child doesn't exist.
    - **Right:** Recursively call `preOrder` on `root.right`. Similar optimization is applied here.
4.  Once all recursive calls resolve, the `result` array containing the preorder traversal is returned by the main function.

- **Time Complexity:** O(N) where N is the number of nodes in the binary tree. We visit each node exactly once.
- **Space Complexity:** O(H) where H is the height of the tree. This is the space required for the call stack during recursion. In the worst case (a skewed tree), the space complexity is O(N). In the best case (a perfectly balanced tree), it's O(log N). The `result` array also takes O(N) space, but this is typically not counted towards auxiliary space complexity as it's required for the output format.

### Iterative Preorder Traversal

An alternative to recursion is an iterative approach using a stack. This achieves the same result and can be useful for very deep trees where recursion might lead to a stack overflow.

1.  **Initialization**:
    - If the `root` is null, return an empty array.
    - Create a `result` array.
    - Create a `stack` and push the `root` node onto it.

2.  **Traversal**:
    - Loop as long as the `stack` is not empty.
    - Pop a `node` from the top of the stack.
    - Add the `node.val` to the `result` array.
    - **Push Children to Stack**: This is the crucial part for preorder. We push the right child first, then the left child. Because a stack is Last-In, First-Out (LIFO), the left child will be processed next, correctly following the Root-Left-Right sequence.
      - If `node.right` exists, push it to the stack.
      - If `node.left` exists, push it to the stack.

3.  **Return**: Once the stack is empty, return the `result` array.

- **Time Complexity:** O(N) - Each node is pushed and popped once.
- **Space Complexity:** O(H) - The space used by the stack will be at most the height of the tree.

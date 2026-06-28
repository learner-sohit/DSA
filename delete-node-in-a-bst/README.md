# 450. Delete Node in a BST

[Link to Problem on LeetCode](https://leetcode.com/problems/delete-node-in-a-bst/)

## Problem Description

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

It is guaranteed that the value to delete exists in the BST.

### Example

**Input:** `root = [5,3,6,2,4,null,7], key = 3`  
**Output:** `[5,4,6,2,null,null,7]`

**Input:** `root = [5,3,6,2,4,null,7], key = 0`  
**Output:** `[5,3,6,2,4,null,7]`

## Explanation

### Iterative Deletion with Inorder Predecessor Replacement

This solution first finds the node to delete iteratively, then replaces it using the rightmost node of its left subtree.

1. If the root is `null`, return `null`.
2. If the root itself holds the key, replace it with `helper(root)`.
3. Otherwise, traverse the tree until the parent of the target node is found.
4. When the left or right child matches the key, replace that child with `helper(child)`.
5. In `helper`:
   - If the node has no left child, return the right child.
   - If the node has no right child, return the left child.
   - If both children exist, save the right subtree, find the rightmost node in the left subtree, attach the saved right subtree there, and promote the left subtree as the replacement.

This keeps the BST valid by using the inorder predecessor from the left subtree when the deleted node has two children.

- **Time Complexity:** O(H), where H is the height of the tree.
- **Space Complexity:** O(1), excluding the tree structure itself.

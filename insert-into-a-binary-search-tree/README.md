# 701. Insert into a Binary Search Tree

[Link to Problem on LeetCode](https://leetcode.com/problems/insert-into-a-binary-search-tree/)

## Problem Description

You are given the root node of a binary search tree (BST) and a value to insert into the tree.

Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

### Example

**Input:** `root = [4,2,7,1,3], val = 5`  
**Output:** `[4,2,7,1,3,5]`

**Input:** `root = [40,20,60,10,30,50,70], val = 25`  
**Output:** `[40,20,60,10,30,50,70,null,null,25]`

## Explanation

The solution file contains iterative and recursive approaches.

### Iterative Approach

The active solution uses the BST property to walk down the tree until it finds the correct empty child position.

1. If the root is `null`, create and return a new node.
2. Start from the root and compare `val` with the current node value.
3. If `val` is smaller, move to the left child.
4. If `val` is greater, move to the right child.
5. When the needed child pointer is `null`, attach the new node there and return the original root.

- **Time Complexity:** O(H), where H is the height of the BST.
- **Space Complexity:** O(1), because the traversal is iterative.

### Recursive Approach

The recursive approach follows the same BST decision at each node.

1. If the current node is `null`, return a new node with `val`.
2. If `val` is smaller than the current node value, insert into the left subtree.
3. Otherwise, insert into the right subtree.
4. Return the current node after updating the correct child link.

- **Time Complexity:** O(H).
- **Space Complexity:** O(H), for the recursive call stack.

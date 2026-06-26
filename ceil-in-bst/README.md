# Ceil in BST

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1)

## Problem Description

Given the root of a Binary Search Tree (BST) and an integer `x`, find the ceil of `x` in the BST.

The ceil of `x` is the smallest value in the BST that is greater than or equal to `x`. If no such value exists, return `-1`.

### Example

**Input:** `root = [5, 1, 7, null, 2], x = 3`  
**Output:** `5`

**Input:** `root = [10, 5, 11, 4, 7, null, null, null, null, null, 8], x = 6`  
**Output:** `7`

## Explanation

### Iterative BST Search

The solution uses the BST property to avoid searching the whole tree.

1. Start with `ceil = -1`.
2. If the current node value equals `x`, return it immediately because it is the best possible ceil.
3. If `x` is greater than the current node value, move to the right subtree because all values on the left are too small.
4. If `x` is smaller than the current node value, the current value is a valid ceil candidate, then move to the left subtree to look for a smaller valid value.
5. When the traversal ends, return the best ceil candidate found.

- **Time Complexity:** O(H), where H is the height of the BST.
- **Space Complexity:** O(1), because the traversal is iterative.

# Floor in BST

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/floor-in-bst/1)

## Problem Description

Given the root of a Binary Search Tree (BST) and an integer `k`, find the floor of `k` in the BST.

The floor of `k` is the greatest value in the BST that is less than or equal to `k`. If no such value exists, return `-1`.

### Example

**Input:** `root = [2, 1, 3], k = 2`  
**Output:** `2`

**Input:** `root = [5, 3, 7, 2, 4, 6, 8], k = 9`  
**Output:** `8`

## Explanation

### Iterative BST Search

The solution uses the BST property to search only the useful side of the tree.

1. Start with `floor = -1`.
2. If the current node value equals `k`, return it immediately because it is the best possible floor.
3. If `k` is greater than the current node value, the current value is a valid floor candidate, then move to the right subtree to look for a larger valid value.
4. If `k` is smaller than the current node value, move to the left subtree.
5. When the traversal ends, return the best floor candidate found.

- **Time Complexity:** O(H), where H is the height of the BST.
- **Space Complexity:** O(1), because the traversal is iterative.

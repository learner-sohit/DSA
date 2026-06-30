/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// ===== Approach 1: Recursive with Bound (Optimal) =====
// Time Complexity: O(n) | Space Complexity: O(h) — h = height of tree (call stack)
class Solution {
    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] preorder, int bound) {
        if (index == preorder.length || preorder[index] > bound) return null;

        TreeNode root = new TreeNode(preorder[index++]);

        root.left = helper(preorder, root.val);
        root.right = helper(preorder, bound);
        return root;
    }
}

/*
// ===== Approach 2: Brute Force — Iterative Insert =====
// Time Complexity: O(n^2) worst case | Space Complexity: O(n)
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            insert(root, preorder[i]);
        }
        return root;
    }

    private void insert(TreeNode root, int val) {
        TreeNode curr = root;

        while (true) {
            if (val < curr.val) {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    return;
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    return;
                }
                curr = curr.right;
            }
        }
    }
}
*/

/*
// ===== Approach 3: Brute Force — Recursive Insert =====
// Time Complexity: O(n^2) worst case | Space Complexity: O(n)
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        TreeNode root = null;

        for (int val : preorder) {
            root = insert(root, val);
        }
        return root;
    }

    private TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }
}
*/

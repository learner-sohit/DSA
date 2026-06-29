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

// ===== Approach 1: Inorder Traversal (Recursive with prev pointer) =====
// Time Complexity: O(n) | Space Complexity: O(h) — h = height of tree (call stack)
class Solution {
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        if (!isValidBST(root.left))
            return false;

        if (prev != null && prev.val >= root.val)
            return false;

        prev = root;

        return isValidBST(root.right);
    }
}

/*
// ===== Approach 2: Morris Traversal (Inorder, O(1) space) =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;

        while (curr != null) {
            if (curr.left == null) {
                if (prev != null && prev.val >= curr.val) return false;

                prev = curr;
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    if (prev != null && prev.val >= curr.val) return false;

                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        return true;
    }
}
*/

/*
// ===== Approach 3: Recursive Range (min/max bounds) =====
// Time Complexity: O(n) | Space Complexity: O(h) — h = height of tree (call stack)
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max) return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
*/

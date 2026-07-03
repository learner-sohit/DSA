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

// ===== Approach 2: Optimal — Single Post-order Pass with NodeInfo =====
// Time Complexity: O(n) | Space Complexity: O(h) — h = height of tree (call stack)
class Solution {
    int ans;

    class NodeInfo {
        boolean isBST;
        int min;
        int max;
        int sum;

        NodeInfo(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    public int maxSumBST(TreeNode root) {
        ans = 0;
        helper(root);
        return ans;
    }

    private NodeInfo helper(TreeNode root) {
        if (root == null) return new NodeInfo(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        NodeInfo left = helper(root.left);
        NodeInfo right = helper(root.right);

        if (left.isBST && right.isBST && left.max < root.val && right.min > root.val) {
            int sum = root.val + left.sum + right.sum;
            ans = Math.max(sum, ans);
            int min = Math.min(root.val, left.min);
            int max = Math.max(root.val, right.max);
            return new NodeInfo(true, min, max, sum);
        }
        return new NodeInfo(false, 0, 0, 0);
    }
}

/*
// ===== Approach 1: Brute Force — Check BST + Sum at Every Node =====
// Time Complexity: O(n^2) | Space Complexity: O(h)
class Solution {
    int ans;

    public int maxSumBST(TreeNode root) {
        helper(root);
        return ans;
    }

    private void helper(TreeNode root) {
        if (root == null) return;

        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            ans = Math.max(ans, getSum(root));
        }

        helper(root.left);
        helper(root.right);
    }

    private boolean isBST(TreeNode root, int min, int max) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max) return false;

        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

    private int getSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + getSum(root.left) + getSum(root.right);
    }
}
*/

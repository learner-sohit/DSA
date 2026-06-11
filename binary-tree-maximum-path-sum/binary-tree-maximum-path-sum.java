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
class Solution {
    //////// OPTIMAL SOLUTION ////////
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;

        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        int leftGain = Math.max(0, maxGain(node.left));
        int rightGain = Math.max(0, maxGain(node.right));

        maxSum = Math.max(maxSum, node.val + leftGain + rightGain);

        return node.val + Math.max(leftGain, rightGain);
    }

    /*
    //////// BRUTE-FORCE SOLUTION ////////
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;

        maxSum = Integer.MIN_VALUE;
        computeMaxAt(root);
        return maxSum;
    }

    private void computeMaxAt(TreeNode node) {
        if (node == null) return;

        int leftGain = Math.max(0, maxDown(node.left));
        int rightGain = Math.max(0, maxDown(node.right));

        maxSum = Math.max(maxSum, node.val + leftGain + rightGain);

        computeMaxAt(node.left);
        computeMaxAt(node.right);
    }

    private int maxDown(TreeNode node) {
        if (node == null) return 0;

        int leftGain = Math.max(0, maxDown(node.left));
        int rightGain = Math.max(0, maxDown(node.right));

        return node.val + Math.max(leftGain, rightGain);
    }
    */
}

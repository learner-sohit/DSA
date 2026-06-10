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
    ////////OPTIMAL SOLUTION////
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        maxDiameter = 0;
        height(root);
        return maxDiameter;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    /*
    ////////BRUTE-FORCE SOLUTION////////
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int currDiameter = leftHeight + rightHeight;

        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        return Math.max(
            currDiameter,
            Math.max(leftDiameter, rightDiameter)
        );
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(
            height(node.left),
            height(node.right)
        );
    }
    */
}

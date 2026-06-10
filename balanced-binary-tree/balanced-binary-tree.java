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
    ////////OPTIMAL SOLUTION/////////
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = dfs(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = dfs(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }

    /*
    ///////Brute force solution//////////
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return (Math.abs(leftHeight - rightHeight) <= 1)
            && isBalanced(root.left)
            && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if(node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
    */
}

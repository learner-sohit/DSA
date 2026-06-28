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
    //////// MORRIS TRAVERSAL SOLUTION ////////
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        int count = 0;

        while (curr != null) {
            if (curr.left == null) {
                count++;
                if (count == k) return curr.val;
                curr = curr.right;
            } else {
                TreeNode node = curr.left;

                while (node.right != null && node.right != curr) {
                    node = node.right;
                }

                if (node.right == null) {
                    node.right = curr;
                    curr = curr.left;
                } else {
                    node.right = null;
                    count++;
                    if (count == k) return curr.val;
                    curr = curr.right;
                }
            }
        }

        return -1;
    }
}

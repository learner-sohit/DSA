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

// ===== Approach 1: Inorder + Sort + Reassign =====
// Time Complexity: O(n log n) | Space Complexity: O(n)
class Solution {
    int idx = 0;

    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        findInorder(root, list);
        Collections.sort(list);
        TreeNode curr = root;
        helper(curr, list);
    }

    private void helper(TreeNode curr, List<Integer> list) {
        if (curr == null) return;

        helper(curr.left, list);
        if (curr.val != list.get(idx)) {
            curr.val = list.get(idx);
        }
        idx++;
        helper(curr.right, list);
    }

    private void findInorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        findInorder(root.left, list);
        list.add(root.val);
        findInorder(root.right, list);
    }
}

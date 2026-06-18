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
    public List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        if (isLeaf(root)) {
            result.add(root.val);
            return result;
        }

        result.add(root.val);
        addLeftBoundary(root.left, result);
        addLeaves(root, result);
        addRightBoundary(root.right, result); // Right boundary is added in reverse

        return result;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private void addLeftBoundary(TreeNode curr, List<Integer> result) {
        while (curr != null) {
            if (!isLeaf(curr)) result.add(curr.val);
            curr = (curr.left != null) ? curr.left : curr.right;
        }
    }

    private void addLeaves(TreeNode curr, List<Integer> result) {
        if (curr == null) return;

        if (isLeaf(curr)) {
            result.add(curr.val);
            return;
        }
        addLeaves(curr.left, result);
        addLeaves(curr.right, result);
    }

    private void addRightBoundary(TreeNode curr, List<Integer> result) {
        Stack<Integer> st = new Stack<>();

        while (curr != null) {
            if (!isLeaf(curr)) st.push(curr.val);
            curr = (curr.right != null) ? curr.right : curr.left;
        }

        while (!st.isEmpty()) {
            result.add(st.pop());
        }
    }
}

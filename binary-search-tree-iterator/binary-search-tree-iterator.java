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

// ===== Method 2: Precomputed Inorder List =====
// Time Complexity: O(n) constructor, O(1) next() and hasNext()
// Space Complexity: O(n) — stores all node values upfront
class BSTIterator {
    List<Integer> list;
    int idx;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        idx = 0;
        helper(root);
    }

    public int next() {
        return list.get(idx++);
    }

    public boolean hasNext() {
        if (idx >= list.size()) return false;
        return true;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
}

/*
// ===== Method 1: Controlled Iteration using Stack (Space-Optimal) =====
// Time Complexity: O(1) amortized for next() | Space Complexity: O(h) — h = height of tree
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
*/

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

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

// ===== Approach 2: Two BST Iterators (Two-Pointer, Optimal) =====
// Time Complexity: O(n) | Space Complexity: O(h) — h = height of tree
class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    boolean reverse;

    public BSTIterator(TreeNode root, boolean reverse) {
        this.reverse = reverse;
        pushAll(root);
    }

    private void pushAll(TreeNode root) {
        while (root != null) {
            stack.push(root);
            if (reverse == true) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }

    public int next() {
        TreeNode root = stack.pop();
        if (reverse == true) {
            pushAll(root.left);
        } else {
            pushAll(root.right);
        }
        return root.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        BSTIterator left = new BSTIterator(root, false);  // inorder (ascending)
        BSTIterator right = new BSTIterator(root, true);  // reverse inorder (descending)

        int i = left.next();
        int j = right.next();

        while (i < j) {
            if (i + j == k) return true;
            else if (i + j > k) j = right.next();
            else i = left.next();
        }
        return false;
    }
}

/*
// ===== Approach 1: Inorder List + Two Pointers =====
// Time Complexity: O(n) | Space Complexity: O(n)
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);

        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) return true;
            else if (sum > k) j--;
            else i++;
        }
        return false;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}
*/

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

// ===== Approach 2: Optimal — Single Inorder Pass (prev/first/middle/last pointers) =====
// Time Complexity: O(n) | Space Complexity: O(h) — h = height of tree (call stack)
class Solution {
    private TreeNode prev, middle, first, last;

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        if (prev.val > root.val) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        first = last = middle = null;
        prev = new TreeNode(Integer.MIN_VALUE);

        inorder(root);

        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
}

/*
// ===== Approach 1: Brute Force — Inorder + Sort + Reassign =====
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
*/

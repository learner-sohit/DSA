import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    //////Iterative soltion using 1 stack///////
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode temp = stack.peek().right;
            if (temp == null) {
                temp = stack.pop();
                result.add(temp.val);
                while (!stack.isEmpty() && temp == stack.peek().right) {
                    temp = stack.pop();
                    result.add(temp.val);
                }
            } else {
                curr = temp;
            }
        }
        return result;
    }

    /*
    //////Iterative soltion using 2 stack///////
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root);
        Stack<Integer> stack2 = new Stack<>();

        while(!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node.val);
            if(node.left != null) stack1.push(node.left);
            if(node.right != null) stack1.push(node.right);
        }

        while(!stack2.isEmpty()) {
            result.add(stack2.pop());
        }
        return result;
    }
    */

    /*
    ///////Recursive solution///////
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        PostOrder(root, result);
        return result;
    }

    private void PostOrder(TreeNode root, List<Integer> result) {
        if(root == null) return;

        PostOrder(root.left, result);
        PostOrder(root.right, result);
        result.add(root.val);
    }
    */
}

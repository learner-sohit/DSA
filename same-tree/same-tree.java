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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /*
    //////// ITERATIVE BFS SOLUTION ////////
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();

        queueP.offer(p);
        queueQ.offer(q);

        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            TreeNode nodeP = queueP.poll();
            TreeNode nodeQ = queueQ.poll();

            if (nodeP == null && nodeQ == null) continue;
            if (nodeP == null || nodeQ == null) return false;
            if (nodeP.val != nodeQ.val) return false;

            queueP.offer(nodeP.left);
            queueP.offer(nodeP.right);
            queueQ.offer(nodeQ.left);
            queueQ.offer(nodeQ.right);
        }

        return queueP.isEmpty() && queueQ.isEmpty();
    }
    */
}

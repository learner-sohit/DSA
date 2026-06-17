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
    class Tuple {
        TreeNode node;
        int row;
        int column;

        Tuple(TreeNode node, int row, int column) {
            this.node = node;
            this.row = row;
            this.column = column;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Tuple> que = new LinkedList<>();
        que.offer(new Tuple(root, 0, 0));

        while (!que.isEmpty()) {
            Tuple curr = que.poll();
            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.column;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            if (node.left != null) que.offer(new Tuple(node.left, row + 1, col - 1));
            if (node.right != null) que.offer(new Tuple(node.right, row + 1, col + 1));
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> list = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }
            result.add(list);
        }
        return result;
    }
}

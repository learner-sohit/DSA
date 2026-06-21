/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    class Tuple {
        int col;
        Node node;

        Tuple(int col, Node node) {
            this.col = col;
            this.node = node;
        }
    }

    //////// OPTIMAL SOLUTION ////////
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> que = new LinkedList<>();
        que.offer(new Tuple(0, root));

        while (!que.isEmpty()) {
            Tuple curr = que.poll();

            int col = curr.col;
            Node node = curr.node;

            map.putIfAbsent(col, node.data);
            if (node.left != null) que.offer(new Tuple(col - 1, node.left));
            if (node.right != null) que.offer(new Tuple(col + 1, node.right));
        }

        for (Integer value : map.values()) {
            result.add(value);
        }

        return result;
    }
}

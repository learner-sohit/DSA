/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    //////// ITERATIVE BST SEARCH ////////
    public int findMaxFork(Node root, int k) {
        int floor = -1;

        while (root != null) {
            if (root.data == k) {
                floor = root.data;
                return floor;
            }

            if (k > root.data) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return floor;
    }
}

/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
}
*/

class Solution {
    //////// ITERATIVE BST SEARCH ////////
    int findCeil(Node root, int x) {
        int ceil = -1;

        while (root != null) {
            if (root.data == x) {
                ceil = root.data;
                return ceil;
            }

            if (x > root.data) {
                root = root.right;
            } else {
                ceil = root.data;
                root = root.left;
            }
        }

        return ceil;
    }
}

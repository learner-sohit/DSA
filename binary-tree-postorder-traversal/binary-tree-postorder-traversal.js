/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var postorderTraversal = function (root) {
  const result = [];
  postOrder(root, result);
  return result;
};

function postOrder(root, result) {
  if (!root) return;

  if (root.left) postOrder(root.left, result);
  if (root.right) postOrder(root.right, result);
  result.push(root.val);
}

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
var preorderTraversal = function (root) {
  const result = [];
  preOrder(root, result);
  return result;
};

function preOrder(root, result) {
  if (!root) return;

  result.push(root.val);
  if (root.left) preOrder(root.left, result);
  if (root.right) preOrder(root.right, result);
}

///////////Iterative solution/////////////
var preorderTraversal_iterative = function (root) {
  if (!root) return [];
  const result = [];
  const stack = [root];

  while (stack.length) {
    const node = stack.pop();
    result.push(node.val);

    if (node.right) stack.push(node.right);
    if (node.left) stack.push(node.left);
  }

  return result;
};

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
////////////Iterative solution//////////////
var inorderTraversal = function (root) {
  if (!root) return [];

  const result = [];
  const stack = [];
  let curr = root;

  while (curr || stack.length) {
    while (curr) {
      stack.push(curr);
      curr = curr.left;
    }

    curr = stack.pop();
    result.push(curr.val);

    curr = curr.right;
  }
  return result;
};

////////////Recursive solution//////////////
var inorderTraversal_recursive = function (root) {
  const result = [];
  inOrder(root, result);
  return result;
};

function inOrder(root, result) {
  if (!root) return;

  if (root.left) inOrder(root.left, result);
  result.push(root.val);
  if (root.right) inOrder(root.right, result);
}

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
//////////////Iterative solution using 1 stack/////////
var postorderTraversal = function (root) {
  const result = [];
  const stack = [];
  let curr = root;

  while (curr || stack.length) {
    while (curr) {
      stack.push(curr);
      curr = curr.left;
    }

    let temp = stack[stack.length - 1].right;

    if (temp === null) {
      temp = stack.pop();
      result.push(temp.val);

      while (stack.length && temp === stack[stack.length - 1].right) {
        temp = stack.pop();
        result.push(temp.val);
      }
    } else {
      curr = temp;
    }
  }
  return result;
};

//////////////Iterative solution using 2 stacks/////////
var postorderTraversal_iterativeTwoStacks = function (root) {
  if (!root) return [];
  const result = [];
  const stack = [root];
  const stack2 = [];

  while (stack.length) {
    const node = stack.pop();
    stack2.push(node.val);

    if (node.left) stack.push(node.left);
    if (node.right) stack.push(node.right);
  }

  while (stack2.length) {
    result.push(stack2.pop());
  }
  return result;
};

//////////////Recursive solution/////////
var postorderTraversal_recursive = function (root) {
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

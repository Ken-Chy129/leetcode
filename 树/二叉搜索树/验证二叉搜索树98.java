package leetcode.树.二叉搜索树;

import java.util.Stack;

/**
 * <pre>
 * 1.递归，每次判断根据上下限判断当前节点是否满足条件
 * 2.中序遍历：二叉搜索树中序遍历后的顺序为从小到大
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/17 16:21
 */
public class 验证二叉搜索树98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val >= upper || node.val <= lower) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long inorder = Long.MIN_VALUE;
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pop.val <= inorder) { // 二叉搜索树中序遍历的节点应该越来越大
                return false;
            }
            inorder = pop.val;
            root = pop.right;
        }
        return true;
    }
}

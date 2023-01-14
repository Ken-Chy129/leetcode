package leetcode.树;

import java.util.Stack;

/**
 * <pre>
 * 1.递归法，可以采用先序遍历，后续遍历，层次遍历，但是不能采用中序遍历，因为中序遍历是左根右，即首先交换左节点的子节点，然后翻转根节点的左右节点，这个时候原本的左节点就变成了右节点，那么最后交换右子树的子节点时，其实还是交换的最开始的左节点，等于最开始根节点的左节点反转了两次，而右节点没有翻转
 * 2.迭代法
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/14 18:16
 */
public class 翻转二叉树226 {
    public TreeNode invertTree(TreeNode root) {
        turn(root);
        return root;
    }
    
    public void turn(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        turn(root.left);
        turn(root.right);
    }

    public TreeNode invertTree2(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            while (node != null) {
                TreeNode tmp = node.right;
                node.right = node.left;
                node.left = tmp;
                stack.push(node);
                node = node.left;
            }
            node = stack.pop().right;
        }
        return root;
    }
}

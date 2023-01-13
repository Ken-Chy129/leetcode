package leetcode.树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 * 1.递归
 * 2.迭代：显式的模拟一个栈，本质上等价于递归
 * 3.Morris：以某个根节点开始，找到他左子树的最右侧节点之后与这个根节点进行连接（其实就是利用null节点来模拟栈，在先序遍历中左子树的最右侧节点的下一个节点就应该回到根节点了（即递归回去以寻找右节点），因为没有用栈额外存储，所以用该null节点事先保存下来，以便后续遍历完之后能回去根节点）
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/13 10:52
 */
public class 二叉树的前序遍历144 {
    // 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(res, root);
        return res;
    }
    
    public void preorder(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(res, root.left);
        preorder(res, root.right);
    }

    // 迭代
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.empty() || node != null) {
            while (node != null) { // 根->左
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop().right; // 右
        }
        return res;
    }

    // Morris
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur1 = root, cur2; // cur1表示当前遍历的节点
        while (cur1 != null) {
            cur2 = cur1.left; // 左子树的根节点
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) { // 寻找左子树最右侧节点
                    cur2 = cur2.right;
                }
                if (cur2.right == null) { // 将最右侧节点的右指针连接上当前遍历的根节点
                    cur2.right = cur1;
                    res.add(cur1.val);
                    cur1 = cur1.left;
                    continue;
                } else { // 最右侧节点已经连接过根节点，则说明这是第二次来到此处，表明已经处理完了左子树，准备回到根节点处，则将其重置为null还原
                    cur2.right = null;
                }
            } else {
                res.add(cur1.val);
            }
            // 如果当前便利的节点的左子树为空，则往右遍历
            cur1 = cur1.right;
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

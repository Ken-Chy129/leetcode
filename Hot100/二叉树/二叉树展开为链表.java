package leetcode.Hot100.二叉树;

import leetcode.分类刷题.树.TreeNode;
import leetcode.数组.二分.搜索插入位置35;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/17 14:24
 */
public class 二叉树展开为链表 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        TreeNode prev = null;
        while (!deque.isEmpty()) {
            TreeNode pop = deque.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = pop;
            }
            TreeNode left = pop.left, right = pop.right;
            if (right != null) {
                deque.push(right); // 保存右节点
            }
            if (left != null) {
                deque.push(left);
            }
            prev = pop;
        }
    }

    public void flatten2(TreeNode root) {
        TreeNode p = root;
        while (p != null) {
            if (p.left != null) { // 因为要将左节点拼接到右节点上，所以得把原本有节点的数据先迁移保存起来
                TreeNode pre = p.left;
                while (pre.right != null) {
                    pre = pre.right; // 找到该子树最右的节点
                }
                pre.right = p.right; // 父节点的右子树一定在左子树最右节点之后，所以将其拼接起来
                p.right = p.left;
                p.left = null;
            }
            p = p.right;
        }
    }

}

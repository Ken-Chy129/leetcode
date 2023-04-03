package leetcode.分类刷题.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/3 17:06
 */
public class 树的操作 {

    // 翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                continue;
            }
            TreeNode left = poll.left;
            poll.left = poll.right;
            poll.right = left;
            queue.offer(poll.left);
            queue.offer(poll.right);
        }
        return root;
    }
}

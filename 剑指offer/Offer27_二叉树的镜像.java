package leetcode.剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/14 19:10
 */
public class Offer27_二叉树的镜像 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            TreeNode tmp = poll.right;
            poll.right = poll.left;
            poll.left = tmp;
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return root;
    }

    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree2(root.right);
        root.right = mirrorTree2(tmp);
        return root;
    }
}

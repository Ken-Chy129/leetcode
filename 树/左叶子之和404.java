package leetcode.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 1.深搜
 * 2.广搜
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/15 23:46
 */
public class 左叶子之和404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + (root.left != null && root.left.left == null && root.left.right == null ? root.left.val : 0); // 等于左子树左叶子节点和+右子树左叶子节点和
    }
    
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                if (poll.left.left == null && poll.left.right == null) {
                    sum += poll.left.val;
                } else {
                    queue.offer(poll.left);
                }
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return sum;
    }
}

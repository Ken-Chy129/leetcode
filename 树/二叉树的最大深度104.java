package leetcode.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 递归(深搜)：一个节点的高度等于其子节点的最大高度加1
 * 广搜：逐层往下，如果这一层有节点的话，将这一层节点的子节点入队，然后答案数+1，然后进入下一层，否则结束
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/15 0:48
 */
public class 二叉树的最大深度104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left) ;
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(); // 获得当前这一层的节点数
            while (size > 0) { // 取出这一层所有的节点，将它们各自的子节点入队
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}

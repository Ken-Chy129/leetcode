package leetcode.暑假修行.搜索和回溯;

import leetcode.分类刷题.树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/17 13:07
 */
public class 从上到下打印二叉树I {

    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                list.add(poll.val);
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

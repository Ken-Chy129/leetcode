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
public class 从上到下打印二叉树II {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                tmp.add(poll.val);
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
            if (tmp.size() != 0) {
                res.add(tmp);
            }
        }
        return res;
    }
}

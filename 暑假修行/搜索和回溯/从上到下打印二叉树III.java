package leetcode.暑假修行.搜索和回溯;

import leetcode.分类刷题.树.TreeNode;

import java.util.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/17 13:07
 */
public class 从上到下打印二叉树III {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                if (reverse) {
                    tmp.addFirst(poll.val);
                } else {
                    tmp.addLast(poll.val);
                }
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
            reverse = !reverse;
            if (tmp.size() != 0) {
                res.add(tmp);
            }
        }
        return res;
    }
    
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                tmp.addLast(poll.val);
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
            if (tmp.size() != 0) {
                res.add(tmp);
            }
            LinkedList<Integer> tmp2 = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                tmp2.addFirst(poll.val);
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
            if (tmp2.size() != 0) {
                res.add(tmp2);
            }
        }
        return res;
    }
}

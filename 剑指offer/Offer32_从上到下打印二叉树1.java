package leetcode.剑指offer;

import java.util.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/12 22:02
 */
public class Offer32_从上到下打印二叉树1 {

    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

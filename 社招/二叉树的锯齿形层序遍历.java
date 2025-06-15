package leetcode.社招;

import leetcode.社招.common.TreeNode;

import java.util.*;

/**
 * @author Ken-Chy129
 * @date 2025/5/21
 */
public class 二叉树的锯齿形层序遍历 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            Deque<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag) {
                    list.addFirst(node.val);
                } else {
                    list.addLast(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            flag = !flag;
            res.add(new LinkedList<>(list));
        }
        return res;
    }
}

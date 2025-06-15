package leetcode.社招;

import leetcode.社招.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author Ken-Chy129
 * @date 2025/5/21
 */
public class 二叉树最大宽度 {

    class Pair<L, R> {

        public L left;
        public R right;

        public Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(root, 1));
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int startValue = 1;
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.left;
                Integer value = pair.right;
                if (i == 0) {
                    startValue = value;
                }
                if (i == size - 1) {
                    res = Math.max(res, value - startValue + 1);
                }
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, value * 2 - 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, value * 2));
                }
            }
        }
        return res;
    }

    public int widthOfBinaryTree2(TreeNode root) {
        dfs(root, 1, 1);
        return res;
    }

    private Map<Integer, Integer> map = new HashMap<>();

    private int res = 0;


    private void dfs(TreeNode root, int depth, int idx) {
        if (root == null) {
            return;
        }
        map.putIfAbsent(depth, idx); // 第一次访问某个层级时一定是最左节点，用map维护每个层级的最左节点
        res = Math.max(res, idx - map.get(depth) + 1); // 遍历每个节点时计算宽度
        idx = idx - map.get(depth) + 1;
        dfs(root.left, depth + 1, idx * 2 - 1);
        dfs(root.right, depth + 1, idx * 2);
    }
}

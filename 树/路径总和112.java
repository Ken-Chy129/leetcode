package leetcode.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 1.深搜
 * 2.广搜
 * 节点的值有可能是负数，所以不能大于targetSum就剪枝
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/16 15:19
 */
public class 路径总和112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, targetSum, root.val);
    }
    
    public boolean dfs(TreeNode root, int targetSum, int nowSum) {
        if (root.left == null && root.right == null) {
            return nowSum == targetSum;
        }
        boolean rs1=false, rs2=false;
        if (root.left != null) {
            rs1 = dfs(root.left, targetSum, nowSum+root.left.val);
        }
        if (root.right != null) {
            rs2 = dfs(root.right, targetSum, nowSum+root.right.val);
        }
        return rs1 || rs2;
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.offer(root);
        sumQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = nodeQueue.poll();
                Integer sum = sumQueue.poll();
                if (node.left == null && node.right == null) {
                    if (sum == targetSum) {
                        return true;
                    }
                }
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    sumQueue.offer(sum+node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    sumQueue.offer(sum+node.right.val);
                }
            }
        }
        return false;
    }
}

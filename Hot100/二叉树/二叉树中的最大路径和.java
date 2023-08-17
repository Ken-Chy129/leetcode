package leetcode.Hot100.二叉树;

import leetcode.分类刷题.树.TreeNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/17 17:14
 */
public class 二叉树中的最大路径和 {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) { // 返回从某个点开始的最大路径和
        if (root == null) {
            return 0;
        }
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        int sum = root.val + left + right;
        if (sum > res) {
            res = sum;
        }

        return root.val + Math.max(left, right);
    }
}

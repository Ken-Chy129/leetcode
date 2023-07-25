package leetcode.暑假修行.搜索和回溯;

import leetcode.分类刷题.树.TreeNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/25 21:14
 */
public class 二叉搜索树的第k大节点 {
    
    int res, k;
    
    public int kthLargest(TreeNode root, int k) {
        dfs(root);
        this.k = k;
        return res;
    } 

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            res = root.val;
            return;
        }
        dfs(root.left);
    }
}

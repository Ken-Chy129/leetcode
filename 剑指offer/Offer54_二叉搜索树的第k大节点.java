package leetcode.剑指offer;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/21 21:57
 */
public class Offer54_二叉搜索树的第k大节点 {

    int res, now;
    
    public int kthLargest(TreeNode root, int k) {
        now = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (now == 0) {
            return;
        }
        if (--now == 0) {
            res = root.val;
        }
        dfs(root.left);
    }
}

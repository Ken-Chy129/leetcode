package leetcode.剑指offer;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/29 18:43
 */
public class Offer68_二叉搜索树的最近公共祖先 {

    TreeNode res;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, Math.max(p.val, q.val), Math.min(p.val, q.val));
        return res;
    }
    
    private void dfs(TreeNode root, int max, int min) {
        if (res != null || root == null) {
            return;
        }
        if (root.val <= max && root.val >= min) {
            res = root;
        } else if (root.val > max) {
            dfs(root.left, max, min);
        } else {
            dfs(root.right, max, min);
        } 
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor2(root.right, p, q);
        }
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor2(root.left, p, q);
        }
        return root;
    }
    
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        while (root != null) {
            if (root.val < min) {
                root = root.right;
            } else if (root.val > max) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }
}

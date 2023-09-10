package leetcode.笔试.腾讯;

import leetcode.分类刷题.树.TreeNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/10 19:59
 */
public class Main {
    
    public int pathNumber (TreeNode root) {
        return dfs(root, 0, 0);
    }

    private int dfs(TreeNode root, int one, int zero) {
        if (root == null) {
            return 0;
        }
        if (root.val == 1) {
            one++;
        } else {
            zero++;
        }
        if (root.left == null && root.right == null) {
            if (one == zero + 1) {
                return 1;
            }
        }
        int count = 0;
        count += dfs(root.left, one, zero);
        count += dfs(root.right, one, zero);
        return count;
    }

    public static void main(String[] args) {
        Main main = new Main();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(0);
        root.left = left;
        root.right = right;
        TreeNode left1 = new TreeNode(1);
        TreeNode left2 = new TreeNode(0);
        left.left = left1;
        left.right = left2;
        right.left = new TreeNode(1);
        System.out.println(main.pathNumber(root));
    }
}

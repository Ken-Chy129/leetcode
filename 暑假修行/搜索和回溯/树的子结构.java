package leetcode.暑假修行.搜索和回溯;

import leetcode.分类刷题.树.TreeNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/22 13:16
 */
public class 树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return compareTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean compareTree(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return compareTree(a.left, b.left) && compareTree(a.right, b.right);
    }
}

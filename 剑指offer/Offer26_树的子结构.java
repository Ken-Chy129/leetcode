package leetcode.剑指offer;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/14 17:42
 */
public class Offer26_树的子结构 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return check(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean check(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return check(a.left, b.left) && check(a.right, b.right);
    }
    
}

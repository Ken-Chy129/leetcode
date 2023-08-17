package leetcode.Hot100.二叉树;

import leetcode.分类刷题.树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/17 11:55
 */
public class 验证二叉搜索树 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }

    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        long min = Long.MIN_VALUE;
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            if (root.val < min) {
                return false;
            } else {
                min = root.val;
            } 
            root = root.right;
        }
        return true;
    }
}

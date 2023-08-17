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
 * @since 2023/8/17 13:48
 */
public class 二叉搜索树中第K小的元素 {

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }
}

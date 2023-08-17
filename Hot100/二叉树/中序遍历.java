package leetcode.Hot100.二叉树;

import leetcode.分类刷题.树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/16 17:11
 */
public class 中序遍历 {
    
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        recursion(root);
        return res;
    }

    private void recursion(TreeNode root) {
        if (root == null) {
            return;
        }
        recursion(root.left);
        res.add(root.val);
        recursion(root.right);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}

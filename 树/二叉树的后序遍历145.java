package leetcode.树;

import jdk.jshell.VarSnippet;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 * 与中序的不同之处在于：
 *   中序遍历中，从栈中弹出的节点，其左子树是访问完了，可以直接访问该节点，然后接下来访问右子树。
 *   后序遍历中，从栈中弹出的节点，我们只能确定其左子树肯定访问完了，但是无法确定右子树是否访问过。
 * 因此，我们在后序遍历中，引入了一个prev来记录历史访问记录。当访问完一棵子树的时候，我们用prev指向该节点。
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/13 14:43
 */
public class 二叉树的后序遍历145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(res, root);
        return res;
    }

    public void postorder(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(res, root.left);
        postorder(res, root.right);
        res.add(root.val);
    }
    
    // 迭代法
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null; // 记录上次访问的节点
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 左子树访问完
            root = stack.pop();
            // 先需要确认是否有右子树或者右子树是否已经遍历过
            // 如果没有或者已经访问过则当前节点可以加入
            if (root.right == null || pre == root.right) {
                res.add(root.val);
                pre = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}

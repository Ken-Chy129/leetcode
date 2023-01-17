package leetcode.树.二叉搜索树;

import java.util.Stack;

/**
 * <pre>
 * 1.中序遍历，出来的结果是升序排序，插值最小肯定存在在两个相邻元素之间
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/17 16:58
 */
public class 二叉搜索树的最小绝对差530 {
    
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long last = Integer.MIN_VALUE, ans = Integer.MAX_VALUE;
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            ans = Math.min(ans, pop.val - last);
            last = pop.val;
            root = pop.right;
        }
        return (int)ans;
    }
}

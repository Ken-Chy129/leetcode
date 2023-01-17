package leetcode.树.二叉搜索树;

import java.util.*;

/**
 * <pre>
 * 1.中序遍历
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/17 17:29
 */
public class 二叉搜索树中的众数501 {

    public int[] findMode(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int maxCount = 0, count = 0, last = Integer.MIN_VALUE;
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (last == pop.val) {
                count++;
            } else {
                count = 1;
            }
            if (maxCount == count) {
                list.add(pop.val);
            } else if (maxCount < count) {
                list.clear();
                list.add(pop.val);
                maxCount = count;
            }
            last = pop.val;
            root = pop.right;
        }
        int[] res = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

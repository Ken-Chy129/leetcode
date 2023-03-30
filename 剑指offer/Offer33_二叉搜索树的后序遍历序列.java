package leetcode.剑指offer;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/29 20:45
 */
public class Offer33_二叉搜索树的后序遍历序列 {

    int index;
    
    public boolean verifyPostorder(int[] postorder) {
        index = postorder.length - 1;
        dfs(postorder, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return index < 0;
    }

    private TreeNode dfs(int[] pre, int max, int min) {
        if (index < 0) {
            return null;
        }
        int val = pre[index];
        if (val > max || val < min) {
            return null;
        }
        index--;
        TreeNode node = new TreeNode(val);
        node.right = dfs(pre, max, val);
        node.left = dfs(pre, val, min);
        return node;
    }

    public boolean verifyPostorder2(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    
    private boolean recur(int[] post, int left, int right) {
        if (left >= right) {
            return true;
        }
        int index = left;
        for (; index < right; index++) {
            if (post[index] > post[right]) {
                break;
            }
        }
        for (int p = index; p < right; p++) {
            if (post[p] < post[right]) {
                return false;
            }
        }
        return recur(post, left, index - 1) && recur(post, index, right - 1);
    }
    
    
}

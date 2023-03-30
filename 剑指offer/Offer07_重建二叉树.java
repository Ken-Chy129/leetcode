package leetcode.剑指offer;

import java.util.HashMap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/29 19:45
 */
public class Offer07_重建二叉树 {

    HashMap<Integer, Integer> map = new HashMap<>();
    int[] pre;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, 0, inorder.length - 1);
    }

    private TreeNode dfs(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(root);
        node.left = dfs(root + 1, left, map.get(pre[root]) - 1);
        node.right = dfs(root + map.get(root) - left + 1, map.get(pre[root]) + 1, right);
        return node;
    }
}

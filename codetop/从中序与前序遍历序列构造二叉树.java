package leetcode.codetop;

import leetcode.分类刷题.树.TreeNode;

import java.util.HashMap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/21 16:58
 */
public class 从中序与前序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] inorder, int[] preorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return partition(preorder, map, 0, 0, preorder.length - 1);
    }

    private TreeNode partition(int[] preorder, HashMap<Integer, Integer> map, int index, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int key = map.get(preorder[index]);
        root.left = partition(preorder, map, index + 1, left, key - 1);
        root.right = partition(preorder, map, index + key - left + 1, key + 1, right);
        return root;
    }
}

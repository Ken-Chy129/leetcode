package leetcode.codetop;

import leetcode.分类刷题.树.TreeNode;

import java.util.HashMap;

/**
 * <pre>
 * 题目链接：<a href=https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">从中序与后序遍历序列构造二叉树</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/21 16:43
 */
public class 从中序与后序遍历序列构造二叉树 {
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return partition(postorder, map, postorder.length - 1, 0, postorder.length - 1);
    }
    
    private TreeNode partition(int[] postorder, HashMap<Integer, Integer> map, int index, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index]);
        int key = map.get(postorder[index]);
        root.right = partition(postorder, map, index - 1, key + 1, right);
        root.left = partition(postorder, map, index - right + key - 1, left, key - 1);
        return root;
    }
}

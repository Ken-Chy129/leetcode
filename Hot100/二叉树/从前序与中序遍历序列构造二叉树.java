package leetcode.Hot100.二叉树;

import leetcode.分类刷题.树.TreeNode;

import java.util.HashMap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/17 15:38
 */
public class 从前序与中序遍历序列构造二叉树 {

    HashMap<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int index, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int key = map.get(preorder[index]);
        root.left = build(preorder, index + 1, left, key - 1);
        root.right = build(preorder, index + key - left + 1, key + 1, right); // key - left表示左区间的长度
        return root;
    }
}

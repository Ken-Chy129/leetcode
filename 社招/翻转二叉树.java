package leetcode.社招;

import leetcode.社招.common.TreeNode;

/**
 * @author Ken-Chy129
 * @date 2025/5/22
 */
public class 翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

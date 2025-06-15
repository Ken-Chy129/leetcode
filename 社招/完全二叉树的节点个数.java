package leetcode.社招;

import leetcode.社招.common.TreeNode;

/**
 * @author Ken-Chy129
 * @date 2025/5/22
 */
public class 完全二叉树的节点个数 {


    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}

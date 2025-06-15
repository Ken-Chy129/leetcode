package leetcode.社招;

import leetcode.社招.common.TreeNode;

/**
 * @author Ken-Chy129
 * @date 2025/5/22
 */
public class 二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);
        if (root.left != null && root.right != null) {
            return Math.min(leftMin, rightMin) + 1;
        }
        if (root.left == null) {
            return 1 + rightMin;
        }
        return 1 + leftMin;
    }
}

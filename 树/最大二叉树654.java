package leetcode.树;

import java.util.Arrays;

/**
 * <pre>
 * 递归
 * 单调栈
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/17 11:45
 */
public class 最大二叉树654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode();
        int max = nums[0], index=0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        root.val = max;
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, index));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, index+1, nums.length));
        return root;
    }
    
}

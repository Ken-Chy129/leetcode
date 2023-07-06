package leetcode.codetop;

/**
 * <pre>
 * 题目链接：<a href="https://leetcode.cn/problems/maximum-product-subarray/">乘积最大子数组</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/21 0:07
 */
public class 乘积最大子数组 {

    public int maxProduct(int[] nums) {
        int max, min, res;
        res = max = min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max = Math.max(nums[i], max * nums[i]);
                min = Math.min(nums[i], min * nums[i]);
            } else {
                int tmp = max;
                max = Math.max(nums[i], min * nums[i]);
                min = Math.min(nums[i], tmp * nums[i]);
            } 
            res = Math.max(res, max);
        }
        return res;
    }

}

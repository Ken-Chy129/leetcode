package leetcode.热门题目.动态规划;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/11 16:11
 */
public class 最大子数组和 {

    /*
    1.动态规划中子问题要具有无后效性，即求解问题的过程不会修改以前求解的子问题的结果，如果之前的阶段求解的子问题的结果包含了一些不确定的信息，导致了后面的阶段求解的子问题无法得到，或者很难得到，这叫「有后效性」
    2.子问题需要覆盖所有可能的结果集（如此题子问题为以i为结尾的子数组的最大和，其中肯定包含了最终的结果，且其能推导出下一个子问题的答案，如果将问题子问题设置为以i为结尾的子数组也一样）
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length]; // dp[i]表示以i结尾的最大子数组和
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        int dp = nums[nums.length - 1]; // dp[i]表示以i结尾的最大子数组和
        int res = nums[0];
        for (int i = nums.length - 2; i > 0; i--) {
            dp = Math.max(dp + nums[i], nums[i]);
            res = Math.max(res, dp);
        }
        return res;
    }
    
}

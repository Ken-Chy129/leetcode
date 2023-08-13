package leetcode.Hot100.数组;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/13 10:48
 */
public class 最大子数组和 {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans; 
    }
}

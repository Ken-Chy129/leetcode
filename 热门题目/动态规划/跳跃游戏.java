package leetcode.热门题目.动态规划;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/11 17:33
 */
public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length]; // dp[i]表示第i个元素能否到达最后一个元素
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= nums.length) {
                dp[i] = true;
                continue;
            }
            for (int j = 1; j <= nums[i]; j++) {
                if (dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    public boolean canJump2(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxReach) {
                maxReach = Math.max(maxReach, i + nums[i]);
                if (maxReach >= nums.length) {
                    return true;
                }
            } else {
                return false;
            } 
        }
        return true;
    }
}

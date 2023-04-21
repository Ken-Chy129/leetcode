package leetcode.分类刷题.动态规划.背包;

import java.util.Arrays;

/**
 * <pre>
 * 题目链接：<a href="https://github.com/Ken-Chy129">目标和</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/21 21:21
 */
public class 目标和 {

    public int findTargetSumWays(int[] nums, int target) {
        // 设全部数之和为sum，其中取减号的数之和为neg
        // 那么保持正数的数之和则为sum-neg，那么sum-neg-neg=target
        // 则neg=(sum-target)/2，那么sum-target需要为非负偶数
        // 达到目标和的方案数则为从nums中任意取数得到neg的方案数
        int sum = Arrays.stream(nums).sum();
        if (sum < target || (sum - target) % 2 == 1) {
            return 0;
        }
        sum = (sum - target) / 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = sum - num; j >= 0; j--) {
                if (dp[j] > 0) {
                    dp[j + num] += dp[j];
                }
            }
        }
        return dp[sum];
    }
}

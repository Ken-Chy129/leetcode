package leetcode.Hot100;

import java.util.Arrays;

/**
 * <pre>
 * 题目链接：<a href="https://leetcode.cn/problems/partition-equal-subset-sum/">分割等和子集</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/21 20:50
 */
public class 分割等和子集 {

    public boolean canPartition(int[] nums) {
        int target = Arrays.stream(nums).sum();
        if (target % 2 == 1) {
            return false;
        }
        target /= 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = target - num; j >= 0; j--) {
                if (dp[j]) {
                    dp[j + num] = true;
                    if (dp[target]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
}

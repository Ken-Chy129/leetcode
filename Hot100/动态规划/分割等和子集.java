package leetcode.Hot100.动态规划;

import java.util.Arrays;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/23 17:43
 */
public class 分割等和子集 {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).parallel().sum();
        if ((sum & 1) == 1) {
            return false;
        }
        sum >>= 1;
        boolean[] dp = new boolean[sum];
        dp[0] = true;
        for (int num : nums) {
            for (int j = sum - num; j >= 0; j--) {
                if (dp[j]) {
                    if (j + num == sum) {
                        return true;
                    }
                    dp[j + num] = true;
                }
            }
        }
        return false;
    }
}

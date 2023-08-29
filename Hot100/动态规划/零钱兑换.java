package leetcode.Hot100.动态规划;

import java.util.Arrays;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/24 14:59
 */
public class 零钱兑换 {

    int[] mem;

    public int coinChange(int[] coins, int amount) {
        mem = new int[amount + 1];
        return dfs(coins, amount);
    }

    private int dfs(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (mem[amount] != 0) {
            return mem[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dfs(coins, amount - coin);
            if (res != -1) {
                min = Math.min(min, res + 1);
            }
        }
        mem[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return mem[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j - coin] + 1, dp[j]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

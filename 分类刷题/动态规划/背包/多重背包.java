package leetcode.分类刷题.动态规划.背包;

import java.util.Scanner;

/**
 * <pre>
 * 一个物品最多可以取多次
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/15 15:20
 */
public class 多重背包 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[7];
        int[] coins = new int[]{0, 1, 2, 3, 5, 10, 20};
        int[] dp = new int[1001];
        for (int i = 1; i <= 6; i++) {
            nums[i] = in.nextInt();
        }
        dp[0] = 1;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                for (int k = 1000; k >= coins[i]; k--) {
                    dp[k] += dp[k - coins[i]];
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < 1000; i++) {
            ans += dp[i] > 0 ? 1 : 0;
        }
        System.out.println(ans);
    }
}

package leetcode.分类刷题.动态规划.背包;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/15 14:49
 */
public class 完全背包 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int capacity = in.nextInt(), n = in.nextInt();
        int[] weight = new int[n + 1], value = new int[n + 1], dp = new int[capacity + 1];
        for (int i = 0; i < n; i++) {
            weight[i] = in.nextInt();
            value[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = weight[i]; j <= capacity; j++) {
                dp[j] = Math.max(dp[j - weight[i]] + value[i], dp[j]);
            }
        }
    }
}

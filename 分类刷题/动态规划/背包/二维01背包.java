package leetcode.分类刷题.动态规划.背包;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/15 14:27
 */
public class 二维01背包 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt(), l = in.nextInt(), n = in.nextInt();
        int[] hWeight = new int[n + 1], lWeight = new int[n + 1], value = new int[n + 1];
        int[][] dp = new int[h + 1][l + 1];
        for (int i = 1; i <= n; i++) {
            hWeight[i] = in.nextInt();
            lWeight[i] = in.nextInt();
            value[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = h; j >= hWeight[i]; j--) {
                for (int k = l; k >= lWeight[i]; k--) {
                    dp[j][k] = Math.max(dp[j - hWeight[i]][k - lWeight[i]] + value[i], dp[j][k]);
                }
            }
        }
        System.out.println(dp[h][l]);
    }
}

package leetcode.分类刷题.动态规划.背包;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/15 13:18
 */
public class 背包01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int capacity = in.nextInt(), n = in.nextInt();
        int[] value = new int[105], weight = new int[105];
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= n; i++) {
            weight[i] = in.nextInt();
            value[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = capacity; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j - weight[i]] + value[i], dp[j]);
            }
        }
        System.out.println(dp[capacity]);
    }
}

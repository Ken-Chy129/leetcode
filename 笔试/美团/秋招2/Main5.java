package leetcode.笔试.美团.秋招2;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/26 11:25
 */
public class Main5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n = in.nextInt(), k = in.nextInt();
        int[] num = new int[(int)n];
        int[] dp = new int[(int)n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        dp[0] = num[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + num[i];
        }
        for (int i = (int)n; i >= 1; i--) {
            for (int j = 0; j + i <= n; j++) {
                if (j == 0) {
                    if (Math.abs(dp[j + i - 1] / (double)i - k) < 0.0001) {
                        System.out.println(i);
                        return;
                    }
                } else if (Math.abs((dp[j + i - 1] - dp[j - 1]) / (double)i - k) < 0.001) {
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}

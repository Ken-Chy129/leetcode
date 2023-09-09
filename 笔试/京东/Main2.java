package leetcode.笔试.京东;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/9 19:37
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            dp[i] = Integer.MAX_VALUE >> 1;
        }
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + nums[i]);
            if (i >= 2) {
                dp[i] = Math.min(dp[i], dp[i - 2] + nums[i]);
            }
        }
        System.out.println(dp[n - 1]);
    }
}

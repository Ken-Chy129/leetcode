package leetcode.笔试.携程.秋招;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/7 20:25
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.next().toCharArray();
        int[] dp = new int[chars.length];
        dp[0] = chars[0] == '0' ? 1 : 0;
        int one = chars[0] == '0' ? 0 : 1;
        long res = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '0') {
                dp[i] = dp[i - 1] + 1;
                one--;
            } else {
                one++;
                if (one >= 0) {
                    dp[i] = 0;
                    one = 0;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
            res += dp[i];
        }
        System.out.println(res);
    }
}

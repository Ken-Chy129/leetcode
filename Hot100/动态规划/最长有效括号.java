package leetcode.Hot100.动态规划;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/24 21:12
 */
public class 最长有效括号 {

    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int pre = i - dp[i - 1] - 1; // 上一串有效括号的前一个括号
                if (pre >= 0 && s.charAt(pre) == '(') {
                    // 如(,()(),),第六个括号的长度除了等于以第五个为结尾的长度，还要再+2，因为上一串有小括号的前一个是(，正好和新的)可以构成一组新的有效括号
                    dp[i] = dp[i - 1] + 2;
                    if (pre >= 1) {
                        dp[i] += dp[pre - 1]; // 构成新的有效括号后，还需要再往前查看一个括号，加上其有效长度
                        // 如()(),(,()(),)，前面还会有两组有效长度可以连起来
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

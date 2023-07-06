package leetcode.剑指offer;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/17 23:01
 */
public class Offer46_把数字翻译成字符串 {

    public int translateNum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        if (chars.length == 1) {
            return 1;
        }
        int[] dp = new int[chars.length];
        dp[0] = 1;
        dp[1] = (chars[0] == '1' || chars[0] == '2' && chars[1] <= '5') ? 2 : 1;
        for (int i = 2; i < chars.length; i++) {
            if (chars[i - 1] == '1' || chars[i - 1] == '2' && chars[i] <= '5') {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[chars.length - 1];
    }
}

package leetcode.剑指offer;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/14 21:39
 */
public class Offer10_青蛙跳台阶问题 {

    public int numWays(int n) {
        int[] dp = new int[102];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i -2]) % 1000000007;
        }
        return dp[n];
    }
}

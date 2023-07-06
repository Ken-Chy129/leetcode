package leetcode.分类刷题.动态规划;

import java.io.*;
import java.util.Arrays;

/**
 * <pre>
 * 题目链接：<a href="https://www.luogu.com.cn/problem/P2769">猴子上树</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/21 14:25
 */
public class 猴子上树 {

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        long[] mPos = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            mPos[i] = (int) in.nval;
        }
        in.nextToken();
        int m = (int) in.nval;
        long[] tPos = new long[m + 1];
        for (int i = 1; i <= m; i++) {
            in.nextToken();
            tPos[i] = (int) in.nval;
        }
        Arrays.sort(mPos);
        Arrays.sort(tPos);
        long[][] dp = new long[2][m + 1];
        Arrays.fill(dp[0], Long.MAX_VALUE / 2);
        Arrays.fill(dp[1], Long.MAX_VALUE / 2);
        dp[1][1] = Math.abs(mPos[1] - tPos[1]);
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= Math.min(m, i); j++) {
                dp[i % 2][j] = Math.min(dp[(i + 1) % 2][j], dp[(i + 1) % 2][j - 1]) + Math.abs(mPos[i] - tPos[j]);
            }
        }
        System.out.println(dp[n % 2][m]);
    }
}

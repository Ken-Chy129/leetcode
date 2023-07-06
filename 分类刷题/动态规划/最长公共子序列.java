package leetcode.分类刷题.动态规划;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/14 21:42
 */
public class 最长公共子序列 {

    public String LCS (String s1, String s2) {
        // write code here
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                } 
            }
        }
        Deque<Character> deque = new ArrayDeque<>();
        int i = len1, j = len2;
        while (dp[i][j] != 0) {
            if (dp[i][j] == dp[i][j - 1]) {
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (dp[i][j] > dp[i - 1][j - 1]) {
                i--;
                j--;
                deque.push(s1.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            res.append(deque.pop());
        }
        return "".equals(res.toString()) ? "-1" : res.toString();
    }
}

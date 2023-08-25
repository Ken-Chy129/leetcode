package leetcode.Hot100.动态规划;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/25 17:57
 */
public class 最长回文子串 {

    public String longestPalindrome(String s) {
        int len = s.length(), res = 0, start = 0;
        for (int i = 0; i < len; i++) {
            for (int l = i, r = i; l >= 0 && r < len && s.charAt(l) == s.charAt(r); l--, r++) {
                if (r - l + 1 > res) {
                    start = l;
                    res = r - l + 1;
                }
            }
            for (int l = i, r = i + 1; l >= 0 && r < len && s.charAt(l) == s.charAt(r); l--, r++) {
                if (r - l + 1 > res) {
                    start = l;
                    res = r - l + 1;
                }
            }
        }
        return s.substring(start, start + res);
    }

    public String longestPalindrome2(String s) {
        int len = s.length(), res = 1, start = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int L = 2; L <= len; L++) {
            for (int i = 0, j = i + L - 1; j < len; i++, j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (L == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && L > res) {
                    start = i;
                    res = L;
                }
            }
        }
        return s.substring(start, start + res);
    }
}

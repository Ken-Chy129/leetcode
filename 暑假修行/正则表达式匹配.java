package leetcode.暑假修行;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/6 9:27
 */
public class 正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        s = " " + s;
        p = " " + p;
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 如果下一个字母是*，则当前字母不能单独使用
                if (j + 1 <= m && pp[j + 1] == '*') {
                    continue;
                }
                if (i > 0 && pp[j] != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (ss[i] == pp[j] || pp[j] == '.');
                } else if (pp[j] == '*') {
                    // 匹配0次 || 匹配1,2,3,...次
                    // 匹配1次为dp[i-1][j-2] && ss[i]匹配pp[i-1]
                    // 匹配2次为dp[i-2][j-2] && ss[i-1:i]匹配pp[j-1]
                    // 匹配3次...
                    // dp[i-1][j]包含了之前匹配0,1,2,...次的情况，再判断当次新增的字母ss[i]是否匹配即可编程匹配1,2,3次
                    dp[i][j] = dp[i][j - 2] || (i > 0 && dp[i - 1][j] && (ss[i] == pp[j - 1] || pp[j - 1] == '.'));
                }
            }
        }
        return dp[n][m];
    }
}

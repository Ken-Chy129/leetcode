package leetcode.分类刷题.动态规划;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/14 21:10
 */
public class 最长公共子串 {
    
    public String LCS (String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1][len2];
        int maxLen = 0, index = 0;
        for (int i = 0; i < len2; i++) {
            if (i >= len1) {
                dp[0][i] = 0;
            } else if (str1.charAt(i) == str2.charAt(i)) {
                dp[0][i] = 1;
                maxLen = 1;
                index = i;
            }
        }
        
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                dp[i][j] = str1.charAt(i) == str2.charAt(j) ? dp[i - 1][j - 1] + 1 : 0;
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    index = i;
                }
            }
        }
        return str1.substring(index - maxLen + 1, index + 1);
    }

}

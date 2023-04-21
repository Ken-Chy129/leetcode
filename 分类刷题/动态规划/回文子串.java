package leetcode.分类刷题.动态规划;

/**
 * <pre>
 * 题目链接：<a href="https://leetcode.cn/problems/palindromic-substrings/">回文子串</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/21 20:05
 */
public class 回文子串 {

    // 枚举子串长度，记忆每个子串是否回文便于后续判断更长的子串
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len + 1][len + 1];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int res = len;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j + i < len; j++) {
                if (s.charAt(j) == s.charAt(j + i) && (i == 1 || dp[j + 1][j + i - 1])) {
                    res++;
                }
            }
        }
        return res;
    }

    // 枚举中心点，向两边扩展
    public int countSubstrings2(String s) {
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < len && s.charAt(left--) == s.charAt(right++)) {
                res++;
            }
            left = i;
            right = i + 1;
            while (left >=0 && right < len && s.charAt(left--) == s.charAt(right++)) {
                res++;
            }
        }
        return res;
    }
    
}

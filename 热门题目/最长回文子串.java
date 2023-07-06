package leetcode.热门题目;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/7 20:04
 */
public class 最长回文子串 {

    public String longestPalindrome(String s) {
        int len = s.length();
        int begin = 0, end = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 0; j < len; j++) { // 注意遍历顺序，先遍历后边界，以保证状态转移的前一个值已经计算出来
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else if (j - i < 3) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i + 1][j - 1]; // 因为是先遍历的j，而i小于j，所以dp[i+1][j-1]一定在上一次循环已经得到结果
                }
                if (dp[i][j] && (j - i) > (end - begin)) {
                    begin = i;
                    end = j;
                }
            }
        }
        return s.substring(begin, end + 1);
    }

    public String longestPalindrome2(String s) {
        int begin = 0, end = 0;
        for (int i = 0; i < s.length(); i++) { // 注意遍历顺序，先遍历后边界，以保证状态转移的前一个值已经计算出来
            int left = i - 1, right = i + 1, len = 0;
            while (left >= 0 && right < s.length()) {

            }

        }
        return s.substring(begin, end + 1);
    }

    private int expand(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            } else {
                break;
            }
        }
        return r - l;
    }
}



package leetcode.Hot100.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/23 10:55
 */
public class 分割回文串 {
    
    List<List<String>> res = new ArrayList<>();

    boolean[][] dp;
    
    public List<List<String>> partition(String s) {
        dp = new boolean[s.length()][s.length()];
        for (int right = 0; right < s.length(); right++) {
            for (int left = 0; left <= right; left++) {
                dp[left][right] = left == right || s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1]);
            }
        }
        dfs(s, 0, new ArrayList<>());
        return res;
    }

    private void dfs(String s, int idx, List<String> tmp) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (dp[idx][i]) {
                tmp.add(s.substring(idx, i + 1));
                dfs(s, i + 1, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        分割回文串 m = new 分割回文串();
        m.partition("efe");
    }
}

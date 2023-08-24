package leetcode.Hot100.动态规划;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/24 16:10
 */
public class 单词拆分 {
    
    boolean[] mem;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        mem = new boolean[s.length()];
        Arrays.fill(mem, true);
        Set<String> collect = new HashSet<>(wordDict);
        return dfs(s, collect, 0);
    }

    private boolean dfs(String s, Set<String> wordSet, int idx) {
        if (idx == s.length()) {
            return true;
        }
        if (!mem[idx]) {
            return false;
        }
        for (int i = idx; i < s.length(); i++) {
            if (wordSet.contains(s.substring(idx, i + 1)) && dfs(s, wordSet, i + 1)) {
                return true;
            }
        }
        mem[idx] = false;
        return false;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

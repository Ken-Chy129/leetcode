package leetcode.Hot100.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/23 0:21
 */
public class 括号生成 {

    List<String> res = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        dfs(new StringBuilder(), 0, 0, n);
        return res;
    }

    private void dfs(StringBuilder sb, int left, int right, int n) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        if (left < right) {
            return;
        }
        if (left < n) {
            sb.append('(');
            dfs(sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < n) {
            sb.append(')');
            dfs(sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

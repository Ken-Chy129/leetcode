package leetcode.Hot100.回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/22 21:31
 */
public class 电话号码的字母组合 {

    List<String> res = new ArrayList<>();

    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        dfs(digits, new StringBuilder(), 0);
        return res;
    }

    private void dfs(String digits, StringBuilder sb, int idx) {
        if (digits.length() == idx) {
            res.add(sb.toString());
            return;
        }
        for (char c : phoneMap.get(digits.charAt(idx)).toCharArray()) {
            sb.append(c);
            dfs(digits, sb, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

package leetcode.热门题目;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/8 0:30
 */
public class 括号生成 {

    private List<Character> list = new ArrayList<>();

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        addBracket(n, 0, 0);
        return res;
    }

    private void addBracket(int n, int left, int right) {
        if (left < right || left > n) {
            return;
        }
        if (2 * n == left + right) {
            res.add(list.stream().map(String::valueOf).collect(Collectors.joining()));
            return;
        }
        list.add('(');
        addBracket(n, left + 1, right);
        list.remove(list.size() - 1);
        list.add(')');
        addBracket(n, left, right + 1);
        list.remove(list.size() - 1);
    }
}

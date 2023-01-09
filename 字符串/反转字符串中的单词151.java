package leetcode.字符串;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 * 1.用栈维护
 * 2.调用api
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/9 13:57
 */
public class 反转字符串中的单词151 {
    
    // 用栈维护
    public String reverseWords(String s) {
        int i = 0, len = s.length();
        Stack<String> stack = new Stack<>();
        while (i<len) {
            while (i < len && s.charAt(i) == ' ') {
                i++;
            }
            if (i == len) {
                break;
            }
            StringBuilder sb = new StringBuilder();
            while (i < len && s.charAt(i) != ' ') {
                sb.append(s.charAt(i++));
            }
            stack.add(sb.toString());
        }
        StringBuilder res = new StringBuilder();
        while (stack.size() > 1) {
            res.append(stack.pop());
            res.append(' ');
        }
        res.append(stack.pop());
        return res.toString();
    }

    // 调用api
    public String reverseWords2(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}

package leetcode.栈与队列;

import java.util.Stack;

/**
 * <pre>
 * 用栈维护
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/11 13:53
 */
public class 有效的括号20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() % 2 == 1) { // 奇数一定不满足
            return false;
        }
        for (int i=0; i<s.length(); i++) {
            if (stack.size() > s.length() - i) { // 剩下的括号数小于当前已存在的括号数一定不满足
                return false;
            }
            if (stack.empty()) {
                stack.push(s.charAt(i));
                continue;
            }
            Character peek = stack.peek();
            char c = s.charAt(i);
            if (peek == '(' && c == ')' || peek == '[' && c == ']' || peek == '{' && c == '}') {
                stack.pop();
            } else if (c == ')' || c == ']' || c == '}') { // 当前是右括号且不与上一个左括号匹配，则一定不满足
                return false;
            } else {
                stack.push(c);
            } 
        }
        return stack.empty();
    }
}

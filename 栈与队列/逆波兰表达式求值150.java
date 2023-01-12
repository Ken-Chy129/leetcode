package leetcode.栈与队列;

import java.util.Stack;

/**
 * <pre>
 * 用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/12 12:04
 */
public class 逆波兰表达式求值150 {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a, b;
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a + b);
                }
                case "-" -> {
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                }
                case "*" -> {
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a * b);
                }
                case "/" -> {
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);
                }
                default -> stack.push(Integer.valueOf(token));
            }
        }
        return stack.peek();
    }

}

package leetcode.栈与队列;

/**
 * <pre>
 * 用StringBuilder模拟栈，以方便最终转换为字符串
 * 也可以采用数组模拟，核心是利用指针指向栈顶元素，维护栈的思想
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/11 14:10
 */
public class 删除字符串中的所有相邻重复项1047 {
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();
        int top = -1;
        for (int i=0; i<s.length(); i++) {
            if (top == -1) {
                stack.append(s.charAt(i));
                top++;
            } else {
                if (stack.charAt(top) == s.charAt(i)) {
                    stack.deleteCharAt(top--);
                } else {
                    stack.append(s.charAt(i));
                    top++;
                } 
            }
        }
        return stack.toString();
    }
}

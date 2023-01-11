package leetcode.栈与队列;

import java.util.Stack;

/**
 * <pre>
 * 首先我们可以想到的方式就是维护两个栈一个存储，一个作为临时移动
 * 每次插入新的元素时，直接入存储的栈，当出队列时，首先把存储栈的所有元素依次移动到临时栈，移动完后临时栈的栈顶元素就是要出队列的元素
 * 此时将其弹出，随后再把元素依次移动回存储栈
 * 这样每次取出元素需要O(n)的时间复杂度
 * 仔细一想我们会发现元素出队列后其实没有必要再把临时栈的所有元素再返回存储栈，只要有元素出栈就从该栈取出即可，因为顺序都是正确的
 * 也就是维护一个插入栈和一个输出栈，每次输出的时候如果输出栈空就把输入栈的元素移动到输出栈，不空就直接输出输出栈的栈顶元素
 * 这样均摊的时间复杂度就是O(1)
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/11 12:18
 */
public class 用栈实现队列232 {
}

class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;
    
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }
}

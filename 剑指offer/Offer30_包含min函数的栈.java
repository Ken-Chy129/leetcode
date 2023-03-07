package leetcode.剑指offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/7 19:19
 */
public class Offer30_包含min函数的栈 {
}

class MinStack {

    private Deque<Integer> elementStack;
    
    private Deque<Integer> minStack;
    
    /** initialize your data structure here. */
    public MinStack() {
        elementStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        elementStack.push(x);
        minStack.push(Math.min(x, minStack.peek()));
    }

    public void pop() {
        elementStack.pop();
        minStack.pop();
    }

    public int top() {
        return elementStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

package leetcode.剑指offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/7 19:00
 */
public class Offer09_用两个栈实现队列 {
}

class CQueue {
    
    Deque<Integer> inStack;
    
    Deque<Integer> outStack;

    public CQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.isEmpty() ? -1 : outStack.pop();
        } else {
            return outStack.pop();
        } 
    }
}

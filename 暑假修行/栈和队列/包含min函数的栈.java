package leetcode.暑假修行.栈和队列;

import java.util.LinkedList;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/11 11:14
 */
public class 包含min函数的栈 {

}

class MinStack {

    private LinkedList<Integer> elementStack, minStack;

    public MinStack() {
        elementStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        elementStack.push(x);
        minStack.push(minStack.peek() < x ? minStack.peek() : x);
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

class MinStack2 {

    private LinkedList<Long> elementStack; // 保存的是x-min

    private long min; // 保存当前最小值

    public MinStack2() {
        elementStack = new LinkedList<>();
    }

    public void push(int x) {
        if (elementStack.isEmpty()) {
            elementStack.push(0L);
            min = x;
        } else {
            elementStack.push(x - min);
            min = Math.min(x, min);
        }
    }

    public void pop() {
        if (elementStack.peek() < 0) { // 说明当前栈顶原值是最小值，所以min=x，并且pop之后min要等与上一个min(oldmin)
            // 由于栈顶保存的是x-min，这里的min是oldmin，所以oldmin = x - peek = min - peek;
            min = min - elementStack.peek();
        }
        elementStack.pop();
    }

    public int top() {
        // 如果栈顶值小于0，说明当前栈顶原值是最小值，那么当前min直接是栈顶原值，直接返回min即可
        // 如果栈顶值大于0，说明当前栈顶原值不是最小值，那么min没有更新，还是原最小值，那么此时栈顶原值为min+peek
        return elementStack.peek() < 0 ? (int)min : (int)(elementStack.peek() + min);
    }

    public int min() {
        return (int)min;
    }
}

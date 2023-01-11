package leetcode.栈与队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 两个队列模拟栈不能和两个栈模拟队列一样实现，因为栈的进出顺序是相反（先入后出）的，所以移动到输出栈后输出就是队列的顺序
 * 而队列的进出顺序是一致（先入先出），所以如果按栈的方法搬移到另一个队列，实质上两个队列顺序都是一样的，没有效果
 * 所以选择将一个队列作为临时队列辅助存储，以保证输入的元素在队列的头部
 * 我们只需要输入前先把队列中的元素移动到另一个队列保存，然后新元素入到原队列后再把临时队列元素重新加回原队列
 * 这样的话插入元素的时间复杂度就是O(n)
 * 
 * 也可以使用一个队列实现，记录下当前元素数量，将新元素入队之后，让队列不断将元素出队再入队，使得前面的元素移动到队列后免去，循环的次数为原本队列的元素数量
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/11 13:29
 */
public class 用队列实现栈225 {
}

class MyStack {

    Queue<Integer> queue;
    Queue<Integer> tmpQueue;
    
    public MyStack() {
        queue = new LinkedList<>();
        tmpQueue = new LinkedList<>();
    }

    public void push(int x) {
        while (!queue.isEmpty()) {
            tmpQueue.add(queue.remove());
        }
        queue.add(x);
        while (!tmpQueue.isEmpty()) {
            queue.add(tmpQueue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.element();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

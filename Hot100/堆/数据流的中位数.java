package leetcode.Hot100.堆;

import java.util.PriorityQueue;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/26 0:36
 */
public class 数据流的中位数 {
}

class MedianFinder {

    private PriorityQueue<Integer> minHeap;
    
    private PriorityQueue<Integer> maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (minHeap.size() == maxHeap.size()) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) >> 1;
        } else {
            return maxHeap.peek();
        }
    }
}

package leetcode.剑指offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/23 22:23
 */
public class Offer41_数据流中的中位数 {

    
}

class MedianFinder {
    
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        if (min.size() == max.size()) {
            max.offer(num);
            min.offer(max.poll());
        } else {
            min.offer(num);
            max.offer(min.poll());
        } 
    }

    public double findMedian() {
        return min.size() == max.size() ? (min.peek() + max.peek()) / 2.0 : min.peek();
    }
}

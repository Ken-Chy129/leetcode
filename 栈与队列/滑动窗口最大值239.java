package leetcode.栈与队列;

import java.util.*;

/**
 * <pre>
 * 1.优先队列，维护元素和其下标，每次移动时将元素入队，只有队列最大元素下标在窗口外时才需移除，然后将最大值记录下来
 * 2.单调队列（当元素比你强还比你年轻时，你就可以滚了）：维护一个队列存储元素的下标，队列中的下标对应的值按从大到小排序，每次遍历一个新的元素，让他取代掉队列中比他小的元素，然后将队首元素作为当次的最大值(前提是队首元素还在窗口内，通过下表判断)
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/12 13:38
 */
public class 滑动窗口最大值239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o2[1]-o1[1] : o2[0]-o1[0]); // 如果两个数一样大，就让序号大的排在前面（减少删除的次数）
        int[] res = new int[nums.length-k+1];
        for (int i=0; i<k; i++) {
            queue.add(new int[]{nums[i], i});
        }
        res[0] = queue.peek()[0];
        for (int i=k; i<nums.length; i++) {
            queue.add(new int[]{nums[i], i});
            while (queue.peek()[1] <= i-k) {
                queue.poll(); // 如果最大元素不在窗口内，那么就将其删除
            }
            // 到这里说明最大元素是在窗口内的，那么当前这个队列的最大元素就是窗口的最大元素
            res[i-k+1] = queue.peek()[0];
        }
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> integerDeque = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        for (int i=0; i<nums.length; i++) {
            while (!integerDeque.isEmpty() && nums[integerDeque.peekLast()] <= nums[i]) {
                integerDeque.pollLast();
            }
            integerDeque.add(i);
            if (integerDeque.peek() <= i - k) {
                integerDeque.poll();
            }
            if (i >= k-1) {
                res[i-k+1] = nums[integerDeque.peek()];
            }
        }
        return res;
    }
}

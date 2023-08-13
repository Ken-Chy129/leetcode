package leetcode.Hot100.子串;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/12 22:17
 */
public class 滑动窗口最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        res.add(nums[deque.peekFirst()]);
        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            res.add(nums[deque.peekFirst()]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = queue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            queue.offer(new int[]{nums[i], i});
            res[i - k + 1] = queue.peek()[0];
        }
        return res;
    }
}

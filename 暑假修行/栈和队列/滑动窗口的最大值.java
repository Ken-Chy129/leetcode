package leetcode.暑假修行.栈和队列;

import java.util.LinkedList;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/11 13:22
 */
public class 滑动窗口的最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            assert k > 0;
            if (i - k >= 0 && deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = deque.peekFirst();
            }
        }
        return res;
    }
}

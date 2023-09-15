package leetcode.笔试.腾讯2;

import leetcode.codetop.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/15 19:58
 */
public class Main {

    public ListNode solve (ListNode[] a) {
        // write code here
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
//        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode[] nums = new ListNode[(int)1e5+5];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            ListNode tmp = a[i];
            while (tmp != null) {
                nums[j++] = tmp;
                tmp = tmp.next;
            }
        }
        Arrays.sort(nums, Comparator.comparingInt(i -> i.val));
        ListNode p = new ListNode(-1), res = p;
        for (int i = 0; i < j; i++) {
            p.next = nums[i];
            p = p.next;
        }
        return res.next;
    }
}

package leetcode.Hot100.链表;

import leetcode.codetop.ListNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/14 13:25
 */
public class 两两交换链表中的节点 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0), pre = dummy;
        dummy.next = head;
        while (pre.next != null && pre.next.next != null) {
            ListNode first = pre.next, second = pre.next.next;
            first.next = second.next;
            second.next = first;
            pre.next = second;
            pre = first;
        }
        return dummy.next;
    }
}

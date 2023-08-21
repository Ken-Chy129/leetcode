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
        ListNode dummy = new ListNode(0), p = dummy;
        dummy.next = head;
        while (p.next != null && p.next.next != null) {
            ListNode first = p.next, second = p.next.next;
            first.next = second.next;
            second.next = first;
            p.next = second;
            p = first;
        }
        return dummy.next;
    }
}

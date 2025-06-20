package leetcode.社招;

import leetcode.codetop.ListNode;

/**
 * @author Ken-Chy129
 * @date 2025/6/20
 */
public class 反转链表 {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

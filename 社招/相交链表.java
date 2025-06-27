package leetcode.社招;

import leetcode.codetop.ListNode;

/**
 * @author Ken-Chy129
 * @date 2025/6/22
 */
public class 相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}

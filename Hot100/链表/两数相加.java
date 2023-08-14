package leetcode.Hot100.链表;

import leetcode.codetop.ListNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/14 13:04
 */
public class 两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), p = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            ListNode node = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10;
            p.next = node;
            p = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            while (l2 != null) {
                ListNode node = new ListNode((l2.val + carry) % 10);
                carry = (l2.val + carry) / 10;
                p.next = node;
                p = node;
                l2 = l2.next;
            }
        } else {
            while (l1 != null) {
                ListNode node = new ListNode((l1.val + carry) % 10);
                carry = (l1.val + carry) / 10;
                p.next = node;
                p = node;
                l1 = l1.next;
            }
        }
        if (carry != 0) {
            p.next = new ListNode(carry);
        }
        return head.next;
    }
}

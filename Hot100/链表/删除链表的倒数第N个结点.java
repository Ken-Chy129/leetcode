package leetcode.Hot100.链表;

import leetcode.codetop.ListNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/14 13:12
 */
public class 删除链表的倒数第N个结点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0), p1 = res, p2 = res;
        res.next = head;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return res.next;
    }
}

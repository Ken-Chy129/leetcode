package leetcode.Hot100.链表;

import leetcode.codetop.ListNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/14 10:42
 */
public class 反转链表 {

    public ListNode reverseList(ListNode head) {
        ListNode p = head, prev = null;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = prev;
            prev = p;
            p = tmp;
        }
        return prev;
    }
}

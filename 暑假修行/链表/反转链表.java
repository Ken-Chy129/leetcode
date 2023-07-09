package leetcode.暑假修行.链表;

import leetcode.codetop.ListNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/9 9:56
 */
public class 反转链表 {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, node;
        while (head != null) {
            node = head.next;
            head.next = prev;
            prev = head;
            head = node;
        }
        return prev;
    }
}

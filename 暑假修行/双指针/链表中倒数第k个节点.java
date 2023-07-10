package leetcode.暑假修行.双指针;

import leetcode.codetop.ListNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/10 9:52
 */
public class 链表中倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode f = head, s = head;
        while (k-- != 0) {
            f = f.next;
        }
        while (f != null) {
            f = f.next;
            s = s.next;
        }
        return s;
    }
}

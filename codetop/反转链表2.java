package leetcode.codetop;

/**
 * <pre>
 * 题目链接：<a href="https://leetcode.cn/problems/reverse-linked-list-ii/">反转链表2</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/20 21:57
 */
public class 反转链表2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i;
        ListNode dummy = new ListNode(0), p = dummy;
        p.next = head;
        for (i = 1; i < left; i++) {
            p = p.next;
        }
        ListNode start = p;
        ListNode prev = p;
        p = p.next;
        while (i < right) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
            i++;
        }
        start.next.next = p;
        start.next = prev;
        return dummy.next;
    }
}

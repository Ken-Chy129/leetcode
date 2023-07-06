package leetcode.codetop;

import java.util.HashSet;

/**
 * <pre>
 * 题目链接：<a href="https://leetcode.cn/problems/linked-list-cycle-ii/">环形链表2</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/20 22:52
 */
public class 环形链表2 {

    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p1 != null) {
            if (p1.next == null) {
                return null;
            }
            p1 = p1.next.next;
            p2 = p2.next;
            if (p1 == p2) {
                p2 = head;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }
}

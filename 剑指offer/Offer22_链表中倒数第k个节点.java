package leetcode.剑指offer;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/18 1:00
 */
public class Offer22_链表中倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p1 = head, p2 = p1;
        for (int i = 0; i < k; i++) {
            p2 = p2.next;
        }
        if (p2 == null) {
            return p1;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1.next;
    }
}

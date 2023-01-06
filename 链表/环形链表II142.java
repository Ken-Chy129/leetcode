package leetcode.链表;

/**
 * <pre>
 * 可以使用快慢指针的方式，让快指针每次走两格，慢指针每次走一格，快指针先入环而且一定会在环中与慢指针相遇
 * 因为在环中对于慢指针来说，其实快指针是以每次1的速度向他逼近，最终一定会碰上
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/6 14:26
 */
public class 环形链表II142 {
    public ListNode detectCycle(ListNode head) {
        ListNode pos1 = head, pos2 = head;
        while (pos2 != null) {
            if (pos2.next == null) {
                return null;
            }
            pos1 = pos1.next;
            pos2 = pos2.next.next;
            if (pos2 == pos1) {
                ListNode p = head;
                while (p != pos1) {
                    p = p.next;
                    pos1 = pos1.next;
                }
                return p;
            }
        }
        return null;
    }
}

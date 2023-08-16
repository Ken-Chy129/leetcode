package leetcode.Hot100.链表;

import leetcode.codetop.ListNode;
import leetcode.分类刷题.树.TreeNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/14 13:51
 */
public class K个一组翻转链表 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0), pre = dummy, end = dummy;
        dummy.next = head;
        while (true) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode last = pre.next;
            pre.next = end;
            do {
                ListNode tmp = head.next;
                head.next = pre;
                pre = head;
                head = tmp;
            } while (pre != end);
            last.next = head;
            pre = last;
            end = last;
        }
        return dummy.next;
    }
}

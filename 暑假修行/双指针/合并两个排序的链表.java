package leetcode.暑假修行.双指针;

import leetcode.codetop.ListNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/10 9:59
 */
public class 合并两个排序的链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0), res = p;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return res.next;
    }
}

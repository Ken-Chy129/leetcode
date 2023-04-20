package leetcode.codetop;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/10 23:11
 */
public class 合并K个升序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1); 
    }
    
    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        return mergeTwoLists(merge(lists, l, (r + l) / 2), merge(lists, (r + l) / 2 + 1, r));
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0), p = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                p.next = a;
                a = a.next;
            } else {
                p.next = b;
                b = b.next;
            }
            p = p.next;
        }
        p.next = a == null ? b : a;
        return dummy.next;
    }
}

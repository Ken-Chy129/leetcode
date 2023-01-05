package leetcode.链表;

/**
 * <pre>
 * <p>可以采用迭代也可以采用递归</p>
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/5 14:58
 */
public class 两两交换链表中的节点24 {

    public ListNode swapPairs(ListNode head) {
        ListNode p = new ListNode(), res = p;
        p.next = head;
        while (p.next != null  && p.next.next != null) {
            ListNode first = p.next, second = p.next.next;
            first.next = second.next;
            second.next = first;
            p.next = second;
            p = first;
        }
        return res.next;
    }

    // 递归
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = swapPairs(head.next.next);
        ListNode second = head.next;
        head.next = next;
        second.next = head;
        return second;
    }
}

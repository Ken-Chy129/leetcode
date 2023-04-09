package leetcode.codetop;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/9 16:13
 */
public class 反转链表 {
    
    
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next); // 找到最后一个节点之后就保持不变
        head.next.next = head; // 反转当前节点和下一节点的指向
        head.next = null; // 当前节点的下一节点置为null防止最后两个节点成环，如果不是最后一个节点则其会在下一次递归更改
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev = null, p = head;
        while (p != null) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return prev;
    }

}

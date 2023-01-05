package leetcode.链表;

/**
 * <pre>
 * <p>翻转链表：迭代或递归</p>
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/5 13:39
 */
public class 翻转链表206 {
    
    // 迭代法
    public ListNode reverseList(ListNode head) {
        ListNode prev=null, p=head, next;
        while (p != null) {
            next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return prev;
    }
    
    // 递归法
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) { // head == null 是用于0长度的链表直接返回
            return head; // 遍历到最后一个节点则返回，这个就是翻转后链表的头
        }
        ListNode newHead = reverseList2(head.next);
        // 如果是1->2->3->...->k->k+1->...->k+n
        // 执行到k时变为1->2->3->...->k->k+1<-...<-k+n
        // 那么k的next是k+1，需要将k+1的next改为k
        head.next.next = head;
        // 将k的next置为null，不然会成环，k指向k+1而k+1指向k
        head.next = null;
        return newHead;
    }
}

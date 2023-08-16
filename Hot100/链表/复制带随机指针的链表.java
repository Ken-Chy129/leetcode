package leetcode.Hot100.链表;

import leetcode.codetop.ListNode;
import leetcode.Hot100.链表.Node;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/16 13:55
 */
public class 复制带随机指针的链表 {

    public Node copyRandomList(Node head) {
        Node p = head;
        while (p != null) {
            Node node = new Node(p.val);
            node.next = p.next;
            p.next = node;
            p = node.next;
        }
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        Node dummy = new Node(0), pre = dummy;
        p = head;
        while (p != null) {
            pre.next = p.next;
            pre = pre.next;
            p.next = pre.next;
            p = p.next;
        }
        return dummy.next;
    }
}

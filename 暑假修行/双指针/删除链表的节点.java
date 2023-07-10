package leetcode.暑假修行.双指针;

import leetcode.codetop.ListNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/10 9:46
 */
public class 删除链表的节点 {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = new ListNode(0), res = node;
        node.next = head;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return res.next;
    }
}

package leetcode.社招;

import leetcode.codetop.ListNode;

/**
 * @author Ken-Chy129
 * @date 2025/6/20
 */
public class K个一组翻转链表 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0), prev = dummy, end = dummy;
        dummy.next = head;
        while (true) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            // 反转前的第一个节点，反转后的最后一个节点
            ListNode orignalHead = head;
            // 上一轮反转后的最后一个节点指向这一轮反转后的第一个节点
            prev.next = end;
            do {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            } while (prev != end);
            // 反转后的最后一个节点与下一组节点连接上
            orignalHead.next = head;
            prev = orignalHead;
            end = orignalHead;
        }
        return dummy.next;
    }
}

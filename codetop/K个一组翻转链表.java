package leetcode.codetop;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/9 21:41
 */
public class K个一组翻转链表 {

    public ListNode reverseKGroup(ListNode head, int k) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy; // p表示上一组的最后一个节点
        while (true) {
            int count = 0;
            ListNode tmp = head;
            while (tmp != null && count < k) {
                deque.push(tmp);
                tmp = tmp.next;
                count++;
            }
            if (count < k) { // 最后一组
                p.next = head;
                break;
            }
            while (!deque.isEmpty()) {
                p.next = deque.pop();
                p = p.next;
            }
            head = tmp;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode p = head;
        int count = 0;
        while (p != null && count < k) {
            p = p.next;
            count++;
        }
        if (count == k) {
            p = reverseKGroup2(p, k); // 拿到下一组的头结点
            while (count != 0) {
                count--;
                ListNode next = head.next;
                head.next = p;
                p = head;
                head = next;
            }
            head = p;
        }
        return head;
    }

    public ListNode reverseKGroup3(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, end = dummy;
        while (true) {
            for (int i = 0; i < k && end != null; i++) { // 找到区间的最后一个元素
                end = end.next;
            }
            if (end == null) { // 如果当前区间元素数量不够k个则直接结束
                break;
            }
            ListNode last = pre.next; // 保存区间的第一个节点，在翻转后其会变为链表尾
            pre.next = end; // 上一个区间的最后一个节点的下一个节点为当前区间的最后一个节点
            do {
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            } while (pre != end); // 此时区间完成翻转，pre==end等于区间的最后一个元素，即新的链表头，head会变为下个区间的第一个节点
            last.next = head; // 链表尾节点的下一个节点就是下一个链表的第一个节点（此处是未反转前）
            pre = last; // 下一个区间的上一个节点就是当前区间的链表尾
            end = last;
        }
        return dummy.next;
    }
    
}

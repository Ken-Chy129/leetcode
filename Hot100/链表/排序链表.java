package leetcode.Hot100.链表;

import leetcode.codetop.ListNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/16 14:54
 */
public class 排序链表 {

    public ListNode sortList(ListNode head) {
        // 1.获取链表的长度
        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        // 选择步长（即分组的长度）
        ListNode dummy = new ListNode(0), pre, left, right;
        dummy.next = head;
        for (int step = 1; step < len; step *= 2) {
            pre = dummy;
            p = dummy.next;
            while (p != null) {
                left = p; // 前一个区间的左节点
                right = cut(left, step); // 切出前一个区间，返回后一个区间的左节点
                p = cut(right, step); // 切出后一个区间，返回第三个区间的左节点（下一次循环中使用）
                pre.next = merge(left, right); // 将上一次合并完的区间的最后一个节点和这次新合并的区间的第一个节点连接
                while (pre.next != null) {
                    pre = pre.next; // 找到这一次合并完的区间的最后一个节点
                }
            }
        }
        return dummy.next;
    }

    // 合并两个区间并排序，返回区间首结点
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    // 从left节点开始，根据步长step将链表切断，并将下一个区间的首结点返回
    private ListNode cut(ListNode start, int step) {
        for (int i = 1; i < step && start != null; i++) {
            start = start.next;
        }
        if (start == null) {
            return null; // 没有下一个区间
        } else {
            ListNode next = start.next;
            start.next = null; // 断开区间
            return next;
        } 
    }
}

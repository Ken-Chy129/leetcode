package leetcode.Hot100.链表;

import leetcode.codetop.ListNode;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/16 15:32
 */
public class 合并K个升序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        var pq = Stream.of(lists).filter(Objects::nonNull).collect(Collectors.toCollection(() -> new PriorityQueue<>(Comparator.comparingInt(a -> a.val))));
        ListNode dummy = new ListNode(0), p = dummy;
        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            p.next = poll;
            p = p.next;
            if (poll != null) {
                pq.add(poll.next);
            }
        }
        return dummy.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        return mergeTwoList(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
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

}

package leetcode.暑假修行.链表;

import leetcode.codetop.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/9 9:29
 */
public class 从尾到头打印链表 {

    int[] res;
    
    int i;
    
    int j;

    public int[] reversePrint(ListNode head) {
        add(head);
        return res;
    }
    
    private void add(ListNode p) {
        if (p == null) {
            res = new int[i];
            return;
        }
        i++;
        add(p.next);
        res[j++] = p.val;
    }

    public int[] reversePrint2(ListNode head) {
        ListNode node = head;
        int i = 0;
        while (node != null) {
            i++;
            node = node.next;
        }
        int[] res = new int[i];
        for (--i;  i >= 0 ; i--) {
            res[i] = head.val;
            head = head.next;
        }
        return res;
    }
}

package leetcode.链表;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <pre>
 * 最简单的方法显然是先遍历一遍链表，知道长度后重新遍历一次就可以找到指定节点了，由此方法我们不难延伸到另一种解法
 * 既然是删除倒数第n个节点，那么也就是一旦遇到最后一个节点那么它前面的第n个节点就是要删除的节点
 * 我们只要使用快慢指针，慢指针在快指针前n位，那么当快指针到达链表尾时慢指针所指的就是需要删除的节点
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/5 14:52
 */
public class 删除链表的倒数第N个结点19 {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pos1=new ListNode(), pos2=head, res = pos1;
        pos1.next = head;
        int i=0;
        while (pos2 != null) {
            if (i < n) { // 找的是链尾的前第n+1个，这样才能删除链尾的第n个
                i++;
            } else {
                pos1 = pos1.next;
            }
            pos2 = pos2.next;
        }
        pos1.next = pos1.next.next;
        return res.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode p = new ListNode(), res = p;
        p.next = head;
        Deque<ListNode> stack = new LinkedList<>();
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        for (int i=0; i<n; i++) {
            stack.pop();
        }
        p = stack.peek();
        p.next = p.next.next;
        return res.next;
    }
}

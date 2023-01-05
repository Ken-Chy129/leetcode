package leetcode.链表;

/**
 * <pre>
 * <p>可以采用迭代，不断判断下一个节点是否要删除；或者采用递归，每次获取子链表的head，如果头节点的值如果等于val就说明返回的是子链表的头</p>
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/5 10:45
 */
public class 移出链表元素203 {
    
    // 迭代
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode p = res;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else { 
                p = p.next;
            }
        }
        return res.next;
    }
    
    // 递归
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements2(head.next, val); // 每次删除子链表，返回子链表的头
        return head.val == val ? head.next : head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

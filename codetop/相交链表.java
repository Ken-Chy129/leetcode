package leetcode.codetop;

/**
 * <pre>
 * 题目链接：<a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/">相交链表</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/20 21:23
 */
public class 相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        boolean flag1 = false, flag2 = false;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == null) {
                if (flag1) {
                    return null;
                }
                flag1 = true;
                p1 = headB;
            }
            if (p2 == null) {
                if (flag2) {
                    return null;
                }
                flag2 = true;
                p2 = headA;
            }
        }
        return p1;
    }
}

package leetcode.Hot100.链表;

import leetcode.codetop.ListNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/14 11:07
 */
public class 回文链表 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode p1 = head, p2 = head, pre = null;
        while (p2 != null && p2.next != null) { // 快指针遍历到尾部时慢指针到中间部分，并且前面的链表已经完成了翻转
            p2 = p2.next.next;
            ListNode tmp = p1.next;
            p1.next = pre;
            pre = p1;
            p1 = tmp;
        }
        ListNode np = pre, nPre = p1;
        if (p2 != null) { // 如果链表长度为奇数，则慢指针在链表最中间点
            p1 = p1.next; // 此点是不用比较的，慢指针前进一格
        }
        boolean res = true;
        // pre指针往前遍历，p1指针往后遍历
        while (pre != null && p1 != null) {
            if (pre.val != p1.val) {
                res = false;
                break;
            }
            pre = pre.next;
            p1 = p1.next;
        }
        while (np != null) { // 恢复链表
            ListNode tmp = np.next;
            np.next = nPre;
            nPre = np;
            np = tmp;
        }
        return res;
    }
}

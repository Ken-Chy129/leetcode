package leetcode.剑指offer;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/8 18:50
 */
public class Offer24_反转链表 {
    
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    ListNode res = null;
    
    public ListNode reverseList2(ListNode head) {
        dfs(null, head);
        return res;
    }
    
    private void dfs(ListNode prev, ListNode node) {
        if (node == null) {
            res = prev;
            return;
        }
        dfs(node, node.next);
        node.next = prev;
    }
}

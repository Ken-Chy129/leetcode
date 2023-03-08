package leetcode.剑指offer;

import java.util.ArrayList;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/8 18:40
 */
public class Offer06_从尾到头打印链表 {
    
    ArrayList<Integer> res = new ArrayList<>();
    
    public int[] reversePrint(ListNode head) {
        dfs(head);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void dfs(ListNode node) {
        if (node == null) {
            return;
        }
        dfs(node.next);
        res.add(node.val);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

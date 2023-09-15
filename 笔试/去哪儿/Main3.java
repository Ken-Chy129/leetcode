package leetcode.笔试.去哪儿;

import leetcode.codetop.ListNode;

import java.util.HashSet;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/15 15:30
 */
public class Main3 {

    public int lengthL (ListNode head) {
        // write code here
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head.val)) {
                set.add(head.val);
                res++;
            }
            head = head.next;
        }
        return res;
    }
}

package leetcode.链表;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * 计算出两个链表的长度，让长的链表先移动到和短的链表一样长（因为交点不可能在前面部分），随后两个链表同时移动，相等时即为交点
 * 或者使用哈希表将第一个链表的元素进行存储，然后遍历第二个链表判断当前节点是否存在在哈希表中
 * 两者时间复杂度相同，但是哈希表需要额外的空间开销（哈希表查找元素是需要O(1)的时间复杂度，所以总的时间开销相同）
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/6 13:49
 */
public class 链表相交160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        int lena=1, lenb=1;
        while (pa != null) {
            pa = pa.next;
            lena++;
        }
        while (pb != null) {
            pb = pb.next;
            lenb++;
        }
        pa = headA;
        pb = headB;
        if (lena > lenb) {
            for (int i=1; i<=lena-lenb; i++) {
                pa = pa.next;
            }
        } else if (lena < lenb) {
            for (int i = 1; i <= lenb - lena; i++) {
                pb = pb.next;
            }
        }
        while (pa != null) {
            if (pa == pb) {
                return pa;
            }
            pa = pa.next;
            pb = pb.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}

package leetcode.剑指offer;

import java.util.HashMap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/8 19:52
 */
public class Offer35_复杂链表的复制 {
    public Node copyRandomList(Node head) {
        Node p = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (p != null) {
            Node tmp = new Node(p.val);
            map.put(p, tmp);
            p = p.next;
        }
        p = head;
        while (p != null) {
            Node node = map.get(p);
            node.next = map.get(p.next);
            node.random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        while (p != null) {
            Node node = new Node(p.val);
            node.next = p.next;
            p.next = node;
            p = node.next;
        }
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        p = head;
        Node res, p2;
        res = p2 = head.next;
        while (p2.next != null) {
            p.next = p.next.next;
            p2.next = p2.next.next;
            p = p.next;
            p2 = p2.next;
        }
        p.next = null;
        return res;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

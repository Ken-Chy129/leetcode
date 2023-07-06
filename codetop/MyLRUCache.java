package leetcode.codetop;

import java.util.HashMap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/9 16:38
 */
public class MyLRUCache {

    class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int size;
    private int capacity;

    public MyLRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.head = new Node(); // 两个哑元节点，方便元素插入删除
        this.tail = new Node();
        this.size = 0;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            moveToTail(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            map.put(key, node);
            size++;
            addLast(node);
            if (size > capacity) {
                map.remove(removeFirst().key);
                size--;
            }
        } else {
            node.value = value;
            moveToTail(node);
        }
    }

    private void moveToTail(Node node) {
        removeNode(node);
        addLast(node);
    }

    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addLast(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
    }

    private Node removeFirst() {
        Node toRemove = head.next;
        head.next = toRemove.next;
        head.next.prev = head;
        return toRemove;
    }

}


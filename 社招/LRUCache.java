package leetcode.社招;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ken-Chy129
 * @date 2025/6/15
 */
public class LRUCache {

    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;

    private final Map<Integer, Node> cache;

    private final Node head;

    private final Node tail;

    public LRUCache(int capacity) {
        assert capacity > 0;
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            Node node = new Node(key, value);
            if (cache.size() >= capacity) {
                Node eliminate = eliminate();
                cache.remove(eliminate.key);
            }
            addToHead(node);
            cache.put(key, node);
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private Node eliminate() {
        Node toBeEliminated = tail.prev;
        removeNode(toBeEliminated);
        return toBeEliminated;
    }
}

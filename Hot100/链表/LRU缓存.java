package leetcode.Hot100.链表;

import java.util.HashMap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/16 16:13
 */
public class LRU缓存 {
    
}

class LRUCache {

    static class LRUNode {
        LRUNode prev, next;
        int val, key;

        public LRUNode() {}

        public LRUNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    HashMap<Integer, LRUNode> map;
    LRUNode first, tail;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        first = new LRUNode();
        tail = new LRUNode();
        first.next = tail;
        tail.prev = first;
    }

    public int get(int key) {
        LRUNode node;
        if ((node = map.get(key)) == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    private void moveToHead(LRUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToHead(node);
    }

    private void addToHead(LRUNode node) {
        LRUNode tmp = first.next;
        first.next = node;
        node.prev = first;
        node.next = tmp;
        tmp.prev = node;
    }

    public void put(int key, int value) {
        LRUNode node = map.get(key);
        if (node == null) {
            if (capacity == map.size()) {
                map.remove(tail.prev.key);
                LRUNode prev = tail.prev.prev;
                prev.next = tail;
                tail.prev = prev;
            }
            node = new LRUNode(key, value);
            addToHead(node);
            map.put(key, node);
        } else {
            node.val = value;
            moveToHead(node);
        }
    }
}

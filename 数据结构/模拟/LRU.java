package leetcode.数据结构.模拟;

import java.util.HashMap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/14 16:06
 */
public class LRU {
    
    static class Node {
        int key;
        
        int value;
        
        Node pre;
        
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    HashMap<Integer, Node> map = new HashMap<>();
    
    Node head = new Node(-1, -1);
    
    Node tail = new Node(-1, -1);
    
    int capacity;
    
    int size;

    public LRU(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToTail(node);
        } else {
            if (size == capacity) {
                Node toDelete = head.next;
                head.next = toDelete.next;
                toDelete.next.pre = head;
                map.remove(toDelete.key);
            } else {
                size++;
            }
            Node node = new Node(key, value);
            node.pre = tail.pre;
            tail.pre.next = node;
            node.next = tail;
            tail.pre = node;
            map.put(key, node);
        } 
    }

    private void moveToTail(Node node) {
        Node pre = node.pre;
        pre.next = node.next;
        node.next.pre = pre;
        Node tailPre = tail.pre;
        tail.pre = node;
        tailPre.next = node;
        node.pre = tailPre;
        node.next = tail;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToTail(node);
            return node.value;
        } else {
            return -1;
        }
    }
}

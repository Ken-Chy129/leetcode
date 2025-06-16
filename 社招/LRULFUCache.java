package leetcode.社招;

import java.util.*;
import java.util.function.Function;

/**
 * @author Ken-Chy129
 * @date 2025/6/16
 */
public class LRULFUCache {

    static class Node {
        private int key, value, frequency;
        private long timestamp;

        public Node(int key, int value, int frequency, long timestamp) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
            this.timestamp = timestamp;
        }
    }

    private final int capacity;

    private Map<Integer, Node> cache;

    private TreeMap<Integer, TreeSet<Node>> frequence2NodesMap;

    public LRULFUCache(int capacity) {
        assert capacity > 0;
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        frequence2NodesMap = new TreeMap<>(Comparator.naturalOrder());
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            update(node);
        } else {
            if (cache.size() >= capacity) {
                evict();
            }
            Node node = new Node(key, value, 1, System.currentTimeMillis());
            cache.put(key, node);
            frequence2NodesMap.computeIfAbsent(1, k -> new TreeSet<>(Comparator.comparingLong(n -> n.timestamp))).add(node);
        }
    }

    private void update(Node node) {
        frequence2NodesMap.get(node.frequency).remove(node);
        if (frequence2NodesMap.get(node.frequency).isEmpty()) {
            frequence2NodesMap.remove(node.frequency);
        }
        node.frequency++;
        node.timestamp = System.currentTimeMillis();
        frequence2NodesMap.computeIfAbsent(node.frequency, k -> new TreeSet<>(Comparator.comparingLong(n -> n.timestamp))).add(node);
    }

    private void evict() {
        Map.Entry<Integer, TreeSet<Node>> firstEntry = frequence2NodesMap.firstEntry();
        TreeSet<Node> nodes = firstEntry.getValue();
        nodes.pollFirst();
        if (nodes.isEmpty()) {
            frequence2NodesMap.remove(firstEntry.getKey());
        }
        cache.remove(firstEntry.getKey());
    }

    public static void main(String[] args) {
        LRULFUCache cache = new LRULFUCache(2);
        cache.put(1, 1);
        System.out.println(cache.get(1));
        cache.put(2, 2);
        System.out.println(cache.get(2));
        cache.put(3, 3);
        System.out.println(cache.get(3));
        System.out.println(cache.get(1));
    }
}

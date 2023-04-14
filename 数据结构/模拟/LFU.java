package leetcode.数据结构.模拟;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/14 16:07
 */
public class LFU {

    static class Node {

        int key;

        int value;

        int cnt;

        public Node(int key, int value, int cnt) {
            this.key = key;
            this.value = value;
            this.cnt = cnt;
        }
    }

    HashMap<Integer, LinkedList<Node>> freMap = new HashMap<>();

    HashMap<Integer, Node> valMap = new HashMap<>();

    int capacity;

    int size;

    int minFre;

    public LFU(int capacity) {
        this.capacity = capacity;
    }

    public void set(int key, int value) {
        Node toSet;
        int freKey;
        if (valMap.containsKey(key)) { // key已存在则修改频率和值
            toSet = valMap.get(key);
            toSet.value = value;
            toSet.cnt++;
            LinkedList<Node> nodes = freMap.get(toSet.cnt - 1); // 将其从原本频率中移除
            nodes.remove(toSet);
            if (minFre == toSet.cnt - 1 && nodes.isEmpty()) {
                minFre++;
            }
            valMap.put(key, toSet);
            freKey = toSet.cnt;
        } else {
            if (size == capacity) {
                Node node = freMap.get(minFre).removeFirst();
                valMap.remove(node.key);
            } else {
                size++;
            }
            toSet = new Node(key, value, 0);
            valMap.put(key, toSet);
            minFre = freKey = 0;
        }
        LinkedList<Node> nodes = freMap.getOrDefault(freKey, new LinkedList<>());
        nodes.add(toSet);
        freMap.put(freKey, nodes);
    }

    public int get(int key) {
        if (valMap.containsKey(key)) {
            Node node = valMap.get(key);
            int fre = node.cnt++;
            LinkedList<Node> nodes = freMap.get(fre);
            nodes.remove(node);
            if (fre == minFre && nodes.isEmpty()) {
                minFre++;
            }
            LinkedList<Node> newNodes = freMap.getOrDefault(node.cnt, new LinkedList<>());
            newNodes.add(node);
            freMap.put(node.cnt, newNodes);
            return node.value;
        } else {
            return -1;
        }
    }
}

class Solution {

    public int[] LFU(int[][] operators, int k) {
        LFU lfu = new LFU(k);
        int[] res = new int[(int) Arrays.stream(operators).filter(x -> x[0] == 2).count()];
        for (int i = 0, j = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                lfu.set(operators[i][1], operators[i][2]);
            } else {
                res[j++] = lfu.get(operators[i][1]);
            }
        }
        return res;
    }

}

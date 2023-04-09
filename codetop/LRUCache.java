package leetcode.codetop;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/9 16:38
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        // 第三个参数为accessOrder，设置为true则表示链表的顺序按访问顺序，false则标识按插入顺序
        this.capacity = capacity;
    }

    public int get(int key) {
        // 会调用afterNodeAccess方法更新当前节点在链表的位置，将其移动到末尾，即表示为最新
        return getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        // HashMap的putVal方法中，如果元素已经存在则会调用afterNodeAccess方法
        // 该方法在LinkedHashMap中有实现
        // 如果按访问排序(即accessOrder设置为true)，则会将当前访问的这个节点移动到链表末尾
        // 并且会在最后调用afterNodeInsertion方法
        super.put(key, value);
    }


    // 该函数会在afterNodeInsertion中被调用，设置删除掉第一个(最老)元素的条件，默认返回false即不删除
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}


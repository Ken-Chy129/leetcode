package leetcode.剑指offer;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * <pre>
 * 1.基于快排数组划分：O(n)
 * 2.大根堆：O(nlogK)
 * 3.二叉搜索树：O(nlogK)
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/23 19:50
 */
public class Offer40_最小的k个数 {
    
    

    // 时间复杂度O(NlogK)，因为二叉堆只需要维护k的大小，所以是logK，比排序的NlogN复杂度更低
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : arr) {
            if (queue.size() < k) {
                queue.offer(i);
            } else if (i < queue.peek()) {
                queue.poll();
                queue.offer(i);
            }
        }
        int[] res = new int[queue.size()];
        for (int i = queue.size() - 1; i >= 0; i--) {
            res[i] = queue.poll();
        }
        return res;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for (int i : arr) {
            if (cnt < k) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                cnt++;
            } else {
                Map.Entry<Integer, Integer> entry = map.lastEntry();
                if (entry.getKey() > i) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                    if (entry.getValue() == 1) {
                        map.pollLastEntry();
                    } else {
                        map.put(i, map.getOrDefault(entry.getKey(), entry.getValue() - 1));
                    }
                }
            } 
        }
        int[] res = new int[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getValue();
            while (num-- > 0) {
                res[i++] = entry.getKey();
            }
        }
        return res;
    }

    public int[] getLeastNumbers3(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        quickSort(arr, k, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int k, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left, j = right;
        int mid = arr[(i + j) / 2];
        while (i <= j) {
            while (arr[i] < mid) {
                i++;
            }
            while (arr[j] > mid) {
                j--;
            }
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if (i > k) {
            quickSort(arr, k, left, j);
        } else if (i < k) {
            quickSort(arr, k, i, right);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

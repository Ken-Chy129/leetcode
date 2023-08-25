package leetcode.Hot100.堆;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/25 21:51
 */
public class 前K个高频元素 {

    private static final Random random = new Random(System.currentTimeMillis());
    
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> tmp = new ArrayList<>(map.values());
        int[] cnt = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            cnt[i] = tmp.get(i);
        }
//        int[] cnts = map.values().stream().mapToInt(Integer::intValue).toArray();
        int left = 0, right = cnt.length - 1, target = cnt.length - k;
        while (true) {
            int index = partition(cnt, left, right);
            if (index == target) {
                tmp.clear();
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() >= cnt[index]) {
                        tmp.add(entry.getKey());
                    }
                }
                int[] res = new int[k];
                for (int i = 0; i < k; i++) {
                    res[i] = tmp.get(i);
                }
                return res;
//                return map.entrySet().stream()
//                        .filter(a -> a.getValue() >= cnts[index])
//                        .map(Map.Entry::getKey)
//                        .mapToInt(Integer::intValue)
//                        .toArray();
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = random.nextInt(left, right + 1);
        swap(nums, left, randomIndex);
        int key = nums[left], i = left + 1, j = right;
        while (true) {
            while (i <= j && nums[i] < key) {
                i++;
            }
            while (i <= j && nums[j] > key) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

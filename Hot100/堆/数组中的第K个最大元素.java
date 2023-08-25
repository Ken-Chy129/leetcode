package leetcode.Hot100.堆;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/25 20:59
 */
public class 数组中的第K个最大元素 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            int top = queue.peek();
            if (nums[i] > top) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }

    private static final Random random = new Random(System.currentTimeMillis());
    
    public int findKthLargest2(int[] nums, int k) {
        int target = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
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
            while (i <= j && nums[i++] < key) {
                i++;
            }
            while (i <= j && nums[j++] > key) {
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

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

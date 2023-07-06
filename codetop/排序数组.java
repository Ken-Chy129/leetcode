package leetcode.codetop;

import java.util.Random;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/10 21:23
 */
public class 排序数组 {

    private Random random = new Random();
    
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int randomIndex = random.nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        int key = nums[left];
        int i = left + 1, j = right;
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
        sort(nums, left, j - 1);
        sort(nums, i, right);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

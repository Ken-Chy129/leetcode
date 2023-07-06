package leetcode.剑指offer;

import java.util.Arrays;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/22 21:51
 */
public class Offer61_扑克牌中的顺子 {

    public boolean isStraight(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        int k = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                k++;
            } else {
                int dis;
                if ((dis = nums[i + 1] - nums[i]) != 1) {
                    if (dis == 0) {
                        return false;
                    }
                    k -= dis - 1;
                    if (k < 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int target = nums[(left + right) / 2];
        int i = left, j = right;
        while (i <= j) {
            while (nums[i] < target) {
                i++;
            }
            while (nums[j] > target) {
                j--;
            }
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        quickSort(nums, left, j);
        quickSort(nums, i, right);
    }
}

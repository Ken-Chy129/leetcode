package leetcode.剑指offer;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/19 20:26
 */
public class Offer57_和为s的两个数字 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target / 2) {
                int find = target - nums[i];
                int left = 0, right = nums.length - 1;
                while (left <= right) {
                    int mid = (right - left) / 2 + left;
                    if (nums[mid] == find) {
                        res[0] = nums[i];
                        res[1] = find;
                        return res;
                    } else if (nums[mid] < find) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return res;
    }

    public int[] twoSum2(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int left = target - nums[i];
            if (left > nums[j]) {
                i++;
            } else if (left < nums[j]) {
                j--;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[0];
    }

    public int[] twoSum3(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(target - nums[i]);
            } else {
                return new int[]{nums[i], target - nums[i]};
            }
        }
        return new int[0];
    }
}

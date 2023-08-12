package leetcode.暑假修行.查找;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/15 9:46
 */
public class 数组中重复的数字 {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (i == nums[i]) {
                i++;
                continue;
            }
            if (nums[nums[i]] != nums[i]) {
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            } else {
                return nums[i];
            }
        }
        return -1;
    }
}

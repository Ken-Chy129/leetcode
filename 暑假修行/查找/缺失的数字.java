package leetcode.暑假修行.查找;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/15 10:54
 */
public class 缺失的数字 {

    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int min = (i + j) >> 1;
            if (nums[min] == min) {
                j = min + 1;
            } else {
                i = min - 1;
            }
        }
        return j + 1;
    }
}

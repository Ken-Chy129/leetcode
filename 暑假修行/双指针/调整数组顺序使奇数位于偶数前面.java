package leetcode.暑假修行.双指针;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/10 10:07
 */
public class 调整数组顺序使奇数位于偶数前面 {

    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (nums[i] % 2 == 1 && i < j) {
                i++;
            }
            while (nums[j] % 2 == 0 && i < j) {
                j--;
            }
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        return nums;
    }
}

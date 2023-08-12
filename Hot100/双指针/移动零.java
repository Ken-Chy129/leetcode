package leetcode.Hot100.双指针;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/12 15:17
 */
public class 移动零 {

    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        for (int k = 0; k < nums.length; j++, k++) {
            if (nums[k] != 0) {
                swap(nums, i, j);
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}

package leetcode.数组.元素的移动;

/**
 * <pre>
 * <p>等同于移动元素题，但是需要输出所有的元素，所以需要把最后的0给补上</p>
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/3 12:56
 */
public class 移动零283 {
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[pos++] = num;
            }
        }
        for (int i=pos; i<nums.length; i++) {
            nums[i] = 0;
        }
    }
}

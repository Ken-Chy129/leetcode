package leetcode.Hot100.数组;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/13 15:48
 */
public class 除自身以外数组的乘积 {

    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length]; // 前缀积，从0乘到i-1
        int[] suffix = new int[nums.length]; // 后缀积，从i+1乘到len-1
        prefix[0] = 1;
        suffix[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }
}

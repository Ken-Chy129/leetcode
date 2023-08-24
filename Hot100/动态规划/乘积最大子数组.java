package leetcode.Hot100.动态规划;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/24 20:23
 */
public class 乘积最大子数组 {

    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, lastMax = 1, lastMin = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = lastMin;
                lastMin = lastMax;
                lastMax = tmp;
            }
            lastMax = Math.max(lastMax * num, num);
            lastMin = Math.min(lastMin * num, num);
            res = Math.max(res, lastMax);
        }
        return res;
    }
}

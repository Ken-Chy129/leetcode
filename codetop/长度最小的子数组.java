package leetcode.codetop;

/**
 * <pre>
 * 题目链接：<a href="https://leetcode.cn/problems/minimum-size-subarray-sum/">长度最小的子数组</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/20 23:12
 */
public class 长度最小的子数组 {

    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j, sum = 0, res = Integer.MAX_VALUE;
        for (j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (sum >= target) {
                while (sum >= target) {
                    sum -= nums[i++];
                }
                res = Math.min(j - i + 2, res);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

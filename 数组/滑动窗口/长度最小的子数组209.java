package leetcode.数组.滑动窗口;

import java.util.Arrays;

/**
 * <pre>
 * <p>滑动窗口求最小窗口O(n)，也可用前缀和+二分O(nlogn)</p>
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/4 14:59
 */
public class 长度最小的子数组209 {

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, ans = Integer.MAX_VALUE;
        for (int i=0, j=0; j<nums.length; j++) {
            sum += nums[j];
            while (sum >= target && i <= j) {
                ans = Math.min(ans, j - i + 1);
                sum -= nums[i++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    
    // 求出前缀和sums,区间[i, j]的和=sums[j]-sums[i]
    // 要使得区间>target，则遍历i，每次使用二分找到最小的j使得sum[i]+target<sum[j]
    public int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1 
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int sum = target + sums[i - 1];
            int bound = Arrays.binarySearch(sums, sum);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

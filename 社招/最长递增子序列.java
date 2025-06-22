package leetcode.社招;

import java.util.Arrays;

/**
 * @author Ken-Chy129
 * @date 2025/6/22
 */
public class 最长递增子序列 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(1);
    }

    public int lengthOfLIS2(int[] nums) {
        int res = 0;
        int[] tail = new int[nums.length];
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int mid = i + (j - i) / 2;
                if (tail[mid] >= num) {
                    j = mid;
                } else {
                    i = mid + 1;
                }
            }
            tail[i] = num;
            if (j == res) {
                res++;
            }
        }
        return res;
    }
}

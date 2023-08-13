package leetcode.Hot100.子串;

import java.util.HashMap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/12 20:58
 */
public class 和为K的子数组 {

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sums = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 和为0的区间有1个
        for (int i = 1; i < nums.length; i++) {
            sums += nums[i];
            res += map.getOrDefault(sums - k, 0);
            map.put(sums, map.getOrDefault(sums, 0) + 1);
        }
        return res;
    }
}

package leetcode.哈希表.数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 分组+哈希
 * 对第一、二个数组维护一个哈希表存储相加的值和出现次数，然后遍历三四组的和，查找map中是否存在与之相反的记录，加上记录数
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/8 15:44
 */
public class 四数相加II454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                map.put(num1 + num2, map.getOrDefault(num1 + num2, 0) + 1);
            }
        }
        int ans = 0;
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                if (map.containsKey(-num3 - num4)) {
                    ans += map.get(-num3 - num4);
                }
            }
        }
        return ans;
    }
}

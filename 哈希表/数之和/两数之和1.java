package leetcode.哈希表.数之和;

import java.util.*;

/**
 * <pre>
 * 1.两重循环暴力遍历数组：O(n^2)
 * 2.哈希表存储+遍历数组判断表中是否存在值使得和为target：O(n)
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/8 15:13
 */
public class 两数之和1 {
    // 暴力遍历数组，二重循环，O(n^2)
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    // 哈希表
    public int[] twoSum2(int[] nums, int target) {
        // value为key所在的下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}



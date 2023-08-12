package leetcode.Hot100.哈希;


import java.util.HashMap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/12 15:01
 */
public class 最长连续序列 {

    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int len = left + right + 1;
                if (res < len) {
                    res = len;
                }
                map.put(num, len); // 保证重复值不会再计算一次
                map.put(num - left, len);
                map.put(num + right, len);
            }
        }
        return res;
    }
}

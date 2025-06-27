package leetcode.社招;

import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ken-Chy129
 * @date 2025/6/23
 */
public class 最长连续序列 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int next = num + 1;
            while (set.contains(next)) {
                next++;
            }
            res = Math.max(res, next - num);
        }
        return res;
    }
}

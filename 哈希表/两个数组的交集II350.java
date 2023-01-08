package leetcode.哈希表;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 同样可以使用哈希表或者排序加双指针方式解决
 * 由于需要保存相同的元素，所以不能用hashSet，而应该选择hashMap维护元素数量
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/8 13:41
 */
public class 两个数组的交集II350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (int i : nums2) {
            Integer orDefault = map.getOrDefault(i, 0);
            map.put(i, orDefault-1);
            if (orDefault > 0) {
                res[index++] = i;
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pos1 = 0, pos2 = 0, i=0;
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        while (pos1 < nums1.length && pos2 < nums2.length) {
            while (pos2 < nums2.length && nums2[pos2] < nums1[pos1]) {
                pos2++;
            }
            if (pos2 < nums2.length && nums2[pos2] == nums1[pos1]) {
                res[i++] = nums2[pos2];
                pos1++;
                pos2++;
                continue;
            }
            pos1++;
        }
        return Arrays.copyOfRange(res, 0, i);
    }
}

package leetcode.哈希表;

import java.util.*;

/**
 * <pre>
 * 维护两个hashSet，hashSet查找元素只需要O(1)的时间
 * 或者对数组首先进行排序，随后使用双指针遍历
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/8 11:43
 */
public class 两个数组的交集349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        if (set1.size() > set2.size()) {
            set2.removeIf(next -> !set1.contains(next));
            int[] res = new int[set2.size()];
            int i = 0;
            for (Integer integer : set2) {
                res[i++] = integer;
            }
            return res;
        } else {
            set1.removeIf(next -> !set2.contains(next));
            int[] res = new int[set1.size()];
            int i = 0;
            for (Integer integer : set1) {
                res[i++] = integer;
            }
            return res;
        }
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pos1 = 0, pos2 = 0, i=0;
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        while (pos1 < nums1.length && pos2 < nums2.length) {
            while (pos2 < nums2.length && nums2[pos2] < nums1[pos1]) {
                pos2++;
            }
            if (pos2 < nums2.length && nums2[pos2] == nums1[pos1]) {
                if (i == 0 || nums1[pos1] != res[i-1]) { // 保证元素的唯一性
                    res[i++] = nums2[pos2];
                }
                pos1++;
                pos2++;
                continue;
            }
            pos1++;
        }
        return Arrays.copyOfRange(res, 0, i);
    }
}

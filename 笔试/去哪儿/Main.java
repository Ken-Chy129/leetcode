package leetcode.笔试.去哪儿;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/15 15:18
 */
public class Main {

    public int[] findQ(int n, int[] nums) {
        // write code here
        HashSet<Integer> set = new HashSet<>();
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                res.addFirst(nums[i]);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}

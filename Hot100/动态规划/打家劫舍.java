package leetcode.Hot100.动态规划;

import leetcode.笔试.帆软.Main;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/24 13:41
 */
public class 打家劫舍 {

    public int rob(int[] nums) {
        int prev = 0, curr = 0;
        for (int num : nums) {
            int tmp = Math.max(curr, prev + num);
            prev = curr;
            curr = tmp;
        }
        return curr;
    }
}

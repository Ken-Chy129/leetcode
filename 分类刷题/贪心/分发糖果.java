package leetcode.分类刷题.贪心;

import java.util.Arrays;
import java.util.Map;

/**
 * <pre>
 * 题目链接：<a href="https://leetcode.cn/problems/candy/">分发糖果</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/25 22:41
 */
public class 分发糖果 {

    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int res = left[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
            res += Math.max(left[i], right[i]);
        }
        return res;
    }
}

package leetcode.分类刷题.动态规划;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/21 18:13
 */
public class 跳跃游戏II {

    public int jump(int[] nums) {
        int maxReach = 0, end = 0, res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, nums[i] + i);
            if (i == end) { // end 表示再多走一步最远能到哪，如果已经走到了上一步能达到的最远距离，那么再往后的就需要多一步才能到达了，而多一步能到的最远距离就是在这上一步覆盖的点最远能到达的地方。
                res++;
                end = maxReach;
            }
        }
        return res;
    }
}

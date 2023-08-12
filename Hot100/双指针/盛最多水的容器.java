package leetcode.Hot100.双指针;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/12 15:23
 */
public class 盛最多水的容器 {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int res = 0;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            int c = h * (j - i);
            if (c > res) {
                res = c;
            }
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }
}

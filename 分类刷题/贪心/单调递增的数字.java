package leetcode.分类刷题.贪心;

/**
 * <pre>
 * 题目链接：<a href="https://leetcode.cn/problems/monotone-increasing-digits/">单调递增的数字</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/25 21:58
 */
public class 单调递增的数字 {

    public int monotoneIncreasingDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int i, j;
        for (i = 1; i < chars.length; i++) {
            if (chars[i] < chars[i - 1]) {
                for (j = i - 1; j >= 0; j--) {
                    if (j == 0 || chars[j] > chars[j - 1]) {
                        chars[j]--;
                        break;
                    }
                }
                for (int k = j + 1; k < chars.length; k++) {
                    chars[k] = '9';
                }
                break;
            }
        }
        return Integer.parseInt(String.valueOf(chars).strip());
    }
}

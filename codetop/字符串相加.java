package leetcode.codetop;

/**
 * <pre>
 * 题目链接：<a href="https://leetcode.cn/problems/add-strings/">字符串相加</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/20 22:31
 */
public class 字符串相加 {

    public String addStrings(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length(), max = Math.max(len1, len2);
        int[] a = new int[max], b = new int[max], c = new int[max + 1];
        for (int i = 0; i < len1; i++) {
            a[i] = num1.charAt(len1 - i - 1) - 48;
        }
        for (int i = 0; i < len2; i++) {
            b[i] = num2.charAt(len2 - i - 1) - 48;
        }
        for (int i = 0; i < max; i++) {
            c[i] += a[i] + b[i];
            c[i + 1] = c[i] / 10;
            c[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        if (c[max] != 0) {
            sb.append(c[max]);
        }
        for (int i = max - 1; i >= 0; i--) {
            sb.append(c[i]);
        }
        return sb.toString();
    }
}

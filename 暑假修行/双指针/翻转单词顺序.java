package leetcode.暑假修行.双指针;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/10 10:08
 */
public class 翻转单词顺序 {

    public String reverseWords(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }

    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1, j = i;
        while (i >= 0) {
            while (j >= 0 && s.charAt(j) == ' ') {
                j--;
            }
            i = j;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            j = i;
            sb.append(s, i + 1, j + 1).append(" ");
        }
        return sb.toString().trim();
    }
}

package leetcode.剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/19 21:15
 */
public class Offer58_翻转单词顺序 {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int p1 = length - 1, p2 = length - 1;
        while (p1 >= 0) {
            while (p2 >= 0 && s.charAt(p2) == ' ') {
                p2--;
            }
            p1 = p2;
            while (p1 >= 0 && s.charAt(p1) != ' ') {
                p1--;
            }
            sb.append(s, p1 + 1, p2 + 1).append(" ");
        }
        return sb.toString().trim();
    }

}

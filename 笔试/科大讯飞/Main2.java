package leetcode.笔试.科大讯飞;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/9 14:46
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.next().toCharArray();
        StringBuilder res = new StringBuilder();
        int i, j;
        for (i = 0, j = 0; j < chars.length; j++) {
            if (chars[j] != chars[i]) {
                res.append(j - i).append(chars[i]);
                i = j;
            }
        }
        res.append(j - i).append(chars[i]);
        System.out.println(res);
    }
}

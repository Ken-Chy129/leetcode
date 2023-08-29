package leetcode.笔试.得物;

import java.io.*;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/29 10:21
 */
public class Main2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), x = in.nextInt();
        char[] cheem = in.next().toCharArray();
        System.out.println(cheem.length);
        int res = 1;
        for (int i = 0; i < n; i++) {
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < n && cheem[left] == cheem[right]) {
                left--;
                right++;
            }
            res = Math.max(res, (right - left - 1));
            left = i; right = i + 1;
            while (left >= 0 && right < n && cheem[left] == cheem[right]) {
                left--;
                right++;
            }
            res = Math.max(res, (right - left - 1));
        }
        System.out.println(res >= x ? "1" : "0");
    }
}

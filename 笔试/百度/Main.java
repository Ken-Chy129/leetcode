package leetcode.笔试.百度;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/12 18:46
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- != 0) {
            int m = in.nextInt(), n = in.nextInt();
            boolean single1 = (m & 1) == 1, single2 = (n & 1) == 1;
            if (single1 && single2) {
                System.out.println("No");
            } else if (single1 || single2) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}

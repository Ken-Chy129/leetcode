package leetcode.笔试.OPPO;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/9 20:41
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), r = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - r; i++) {
            sb.append("(");
            sb.append(")");
        }
        for (int i = 0; i < r; i++) {
            sb.append("(");
        }
        for (int i = 0; i < r; i++) {
            sb.append(")");
        }
        System.out.println(sb);
    }
}

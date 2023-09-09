package leetcode.笔试.OPPO;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/9 20:47
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt(), a = in.nextInt(), d = in.nextInt();
        while (d % 2 == 0) {
            d /= 2;
            n += n - 1;
        }
        System.out.println(n);
    }
}

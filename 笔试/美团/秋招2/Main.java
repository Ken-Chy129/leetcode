package leetcode.笔试.美团.秋招2;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/26 9:59
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
        int day = 2, res = 0;
        while (true) {
            z -= x;
            if (day == 2) {
                z -= y;
            }
            res++;
            if (z <= 0) {
                break;
            }
            day--;
            if (day == -1) {
                day = 2;
            }
        }
        System.out.println(res);
    }
}

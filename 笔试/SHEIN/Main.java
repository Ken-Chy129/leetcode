package leetcode.笔试.SHEIN;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/5 21:04
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int token = 100, begin = 0, res = 0;
        while (n-- != 0) {
            int time = in.nextInt(), num = in.nextInt();
            int dis = (time - begin) / 100;
            token = Math.min(150, token + dis * 10);
            if (num > token) {
                res += num - token;
                token = 0;
            } else {
                token -= num;
            }
            begin = time;
        }
        System.out.println(res);
    }
}

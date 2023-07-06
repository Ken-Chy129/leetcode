package leetcode.携程;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/15 19:12
 */
public class Main1 {

    public static long lgd(long a, long b) {
        long r = a % b;
        return r == 0 ? b : lgd(b, r);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        while (t-- != 0) {
            long n = in.nextLong();
            for (long i = n / 2; i >= 1; i--) {
                long b = n - i;
                if (lgd(i, b) == 1) {
                    System.out.println(i + " " + b);
                    break;
                }
            }
        }
    }
}

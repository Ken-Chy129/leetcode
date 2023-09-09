package leetcode.笔试.京东;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/9 19:43
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = in.nextInt();
        }
        long res = 0;
        final long mod = (long) (Math.pow(10, 9) + 7);
        long[] p = new long[n + 1];
        for (long i = 1; i <= n; i++) {
            p[(int)i] = (i * (i + 1)) / 2;
        }
        for (int i = 1; i <= n; i++) {
            res = (((((long) nums[i] * (n - i + 1)) % mod) * p[i]) % mod + res) % mod;
        }
        System.out.println(res);
    }
}

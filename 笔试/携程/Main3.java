package leetcode.笔试.携程;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/15 20:12
 */
public class Main3 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] nums = new long[n + 1];
        long res = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextLong();
            res = (long) (((res + sum(nums[i])) % (1e9 + 7)) % (1e9 + 7));
        }
        for (int i = 2; i <= n; i+=2) {
            for (int j = 0; j < n - i; j++) {
                res = (long) ((res + Math.min(nums[j], nums[j + i])) % (1e9 + 7));
            }
        }
        System.out.println((long) (res % (1e9 + 7)));
    }

    private static long sum(long n) {
        return (long) ((((((1 + n) % (1e9 + 7)) * n) % (1e9 + 7)) / 2) % (1e9 + 7));
    }
}

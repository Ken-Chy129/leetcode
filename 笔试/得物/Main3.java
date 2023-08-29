package leetcode.笔试.得物;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/29 10:33
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), x = in.nextInt();
        long left = x - 1, right = n - x;
        long i = m / n, j = m - n + 1;
        long res = 0;
        while (i <= j) {
            long mid = (j + i) >> 1;
            long height = sum(left, mid) + sum(right, mid) + mid;
            if (height == m) {
                res = Math.max(res, mid);
                break;
            } else if (height < m) {
                res = Math.max(res, mid);
                i = mid + 1;
            } else {
                j = mid - 1;
            } 
        }
        System.out.println(res);
    }

    static long sum(long cnt, long base) {
        long res = 0;
        for (int i = 0; i < cnt; i++) {
            if (base > 1) {
                base--;
            }
            res += base;
        }
        return res;
    }
}

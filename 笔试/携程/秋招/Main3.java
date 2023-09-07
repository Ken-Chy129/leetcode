package leetcode.笔试.携程.秋招;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/7 19:51
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- != 0) {
            int len = in.nextInt();
            long l = in.nextInt(), r = in.nextInt();
            long[] num = new long[len];
            long less = 0, more = 0, provideLess = 0, provideMore = 0;
            for (int i = 0; i < len; i++) {
                num[i] = in.nextInt();
                if (num[i] < l) {
                    less += l - num[i];
                } else if (num[i] > r) {
                    more += num[i] - r;
                } else {
                    provideLess += r - num[i];
                    provideMore += num[i] - l;
                }
            }
            if (more > less) {
                if (more - less > provideLess) {
                    System.out.println(-1);
                } else {
                    System.out.println(more);
                }
            } else if (less > more) {
                if (less - more > provideMore) {
                    System.out.println(-1);
                } else {
                    System.out.println(less);
                }
            } else {
                System.out.println(less);
            }
        }
    }
}

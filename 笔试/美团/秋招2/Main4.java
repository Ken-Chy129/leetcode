package leetcode.笔试.美团.秋招2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/26 10:56
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        while (q-- != 0) {
            boolean res = true;
            int n = in.nextInt(), m = in.nextInt();
            int[] a = new int[n], b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }
            Arrays.sort(a);
            Arrays.sort(b);
            int begin = 0, end = n - 1;
            int i, j;
            for (i = 0; i < n; i++) {
                if (b[i] < 1) {
                    if (a[end] + b[i] > m || a[end] + b[i] < 1) {
                        res = false;
                        break;
                    }
                    end--;
                } else {
                    break;
                } 
            }
            if (!res) {
                System.out.println("No");
                continue;
            }
            for (j = n - 1; j >= i ; j--) {
                if (b[i] > m) {
                    if (a[begin] + b[i] > m || a[begin] + b[i] < 1) {
                        res = false;
                        break;
                    }
                    begin++;
                } else {
                    break;
                } 
            }
            if (!res) {
                System.out.println("No");
                continue;
            }
            for (int k = i; k <= j; k++) {
                if (a[end] + b[k] > m || a[end] + b[k] < 1) {
                    res = false;
                    break;
                }
                end--;
            }
            System.out.println(res ? "Yes" : "No");
        }
    }

}

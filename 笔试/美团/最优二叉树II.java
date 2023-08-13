package leetcode.笔试.美团;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/11 14:16
 */
public class 最优二叉树II {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] value = new int[num + 2];
        for (int i = 1; i <= num; i++) {
            value[i] = in.nextInt();
        }
        int[][] ldp = new int[num + 2][num + 2];
        int[][] rdp = new int[num + 2][num + 2];
        for (int i = 0; i < num; i++) {
            for (int j = 1; j <= num - i; j++) {
                int x, y;
                int to = j + i;
                ldp[j][to] = rdp[j][to] = Integer.MAX_VALUE;
                for (int k = j; k <= to; k++) {
                    x = ldp[j][k - 1] + rdp[k + 1][to] + value[k] * value[to + 1];
                    y = ldp[j][k - 1] + rdp[k + 1][to] + value[k] * value[j - 1];
                    if (x < ldp[j][to]) {
                        ldp[j][to] = x;
                    }
                    if (y < rdp[j][to]) {
                        rdp[j][to] = y;
                    }
                }
            }
        }
        System.out.println(ldp[1][num]);
    }
}

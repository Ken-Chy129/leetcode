package leetcode.笔试.OPPO;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/9 21:18
 */
public class Main3 {

    static double[] vis = new double[(int) 1e6 + 1];
    
    static int n, k;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        System.out.printf("%.09f", dfs(k, 0));
    }

    private static double dfs(int left, int flag) {
        double res;
        if (flag != 0) {
            return dfs(left, 0) + 1;
        }
        if (left == 1) {
            return n;
        }
        if (vis[left] > 1e-9) {
            return vis[left];
        }
        res = dfs(left - 1, 0) + (double)left / n + 1;
        return vis[left] = res;
    }
}

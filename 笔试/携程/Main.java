package leetcode.笔试.携程;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/19 22:08
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        char[][] mp = new char[n + 1][m + 1];
        in.nextLine();
        for (int i = 0; i < n; i++) {
            mp[i] = in.nextLine().toCharArray();
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                boolean y = false, o = false, u = false;
                for (int p = 0; p <= 1; p++) {
                    for (int q = 0; q <= 1; q++) {
                        if (mp[i + p][j + q] == 'y') {
                            y = true;
                        } else if (mp[i + p][j + q] == 'o') {
                            o = true;
                        } else if (mp[i + p][j + q] == 'u') {
                            u = true;
                        }
                    }
                }
                if (y && o && u) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }

}

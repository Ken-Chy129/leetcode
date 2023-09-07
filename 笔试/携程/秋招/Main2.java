package leetcode.笔试.携程.秋招;

import java.util.HashSet;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/7 19:28
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = in.next().toCharArray();
        }
        int[][] row = new int[n][3];
        int[][] col = new int[m][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int index = getIndex(map[i][j]);
                if (index == -1) {
                    continue;
                }
                row[i][getIndex(map[i][j])]++;
                col[j][getIndex(map[i][j])]++;
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'y') {
                    res += (long)row[i][1] * col[j][2] + (long)row[i][2] * col[j][1];
                }
                if (map[i][j] == 'o') {
                    res += (long)row[i][0] * col[j][2] + (long)row[i][2] * col[j][0];
                }
                if (map[i][j] == 'u') {
                    res += (long)row[i][0] * col[j][1] + (long)row[i][1] * col[j][0];
                }
            }
        }
        System.out.println(res);
    }

    private static int getIndex(char c) {
        if (c == 'y') {
            return 0;
        }
        if (c == 'o') {
            return 1;
        }
        if (c == 'u') {
            return 2;
        }
        return -1;
    }
}

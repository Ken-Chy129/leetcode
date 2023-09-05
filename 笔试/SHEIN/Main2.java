package leetcode.笔试.SHEIN;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/5 21:39
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] map = new char[1001][1001];
        String str = in.next();
        String[] split = str.split(",");
        int row = Integer.parseInt(split[1]), cnt = 0, col = 0;
        str = split[0];
        System.out.println(row);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 1001; j++) {
                map[i][j] = '\n';
            }
        }
        boolean mid = false;
        for (int i = 0; i < str.length(); i++) {
            map[cnt][col] = str.charAt(i);
            if (mid) {
                col++;
                cnt--;
                if (cnt == 0) {
                    mid = false;
                }
                continue;
            }
            if (cnt == row - 1) {
                col++;
                cnt--;
                mid = true;
                continue;
            }
            cnt++;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 1001; j++) {
                if (map[i][j] != '\n') {
                    System.out.print(map[i][j]);
                }
            }
        }
    }
}

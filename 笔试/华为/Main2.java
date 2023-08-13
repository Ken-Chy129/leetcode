package leetcode.笔试.华为;

import java.util.Random;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/5/6 20:38
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        Random rd = new Random();
        System.out.println(rd.nextInt(i, 2 * i));
    }

    // 处理特殊字符的加法
    private static double specialAdd(char i, char j) {
        double result = 0;
        if (i=='!' && j=='!') {
            return 0;
        }
        if (i=='!' && j=='@') {
            return 13;
        }
        if (i=='@' && j=='!') {
            return 13;
        }
        if (i=='!' && j=='#') {
            return 4;
        }
        if (i=='#' && j=='!') {
            return 4;
        }
        if (i=='@' && j=='@') {
            return 7;
        }
        if (i=='@' && j=='#') {
            return 20;
        }
        if (i=='#' && j=='#') {
            return 5;
        }
        if (i=='#' && j=='@') {
            return 20;
        }
        return result;
    }
}

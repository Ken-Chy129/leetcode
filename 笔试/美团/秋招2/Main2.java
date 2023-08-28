package leetcode.笔试.美团.秋招2;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/26 10:14
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int billCnt = in.nextInt(), allPeopleCnt = in.nextInt();
        int[] res = new int[allPeopleCnt + 1];
        while (billCnt-- != 0) {
            int peopleCnt = in.nextInt(), fee = in.nextInt();
            for (int i = 0; i < peopleCnt - 1; i++) {
                res[in.nextInt()] += Math.ceil(fee / (double)(peopleCnt + 1));
            }
        }
        for (int i = 1; i <= allPeopleCnt; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

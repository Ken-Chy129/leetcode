package leetcode.笔试.腾讯;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/10 21:03
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        long res = 0, fight = 0;
        int i, j;
        for (i = 0, j = n - 1; i < j; i++, j--) {
            if (fight < nums[j]) {
                res += nums[j] - fight;
            }
            fight = nums[i];
        }
        if (i == j && nums[j] > fight) {
            res += nums[j] - fight;
        }
        System.out.println(res);
    }
}

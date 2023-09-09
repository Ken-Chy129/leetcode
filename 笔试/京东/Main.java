package leetcode.笔试.京东;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/9 19:28
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        long res = 0;
        for (int i = n - 1; i >= 1; i--) {
            if (nums[i] - nums[i - 1] <= k) {
                res += (long)nums[i] * nums[i - 1];
                i--;
            }
        }
        System.out.println(res);
    }
}

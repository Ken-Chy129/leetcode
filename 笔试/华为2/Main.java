package leetcode.笔试.华为2;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/20 19:22
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int target = in.nextInt();
        boolean first = true;
        int start = -1, end = -1;
        if (nums[0] == target) {
            start = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] == target) {
                    if (first) {
                        end = i;
                    } else {
                        start = i;
                    }
                }
                if (nums[i] != target) {
                    first = false;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (nums[i] == target) {
                    if (first) {
                        start = i;
                        end = i;
                        first = false;
                    } else {
                        end = i;
                    }
                }
            }
        }
        System.out.println(start + " " + end);
    }
}

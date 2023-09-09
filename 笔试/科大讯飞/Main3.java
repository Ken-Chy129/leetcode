package leetcode.笔试.科大讯飞;

import java.util.HashSet;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/9 15:01
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[] nums = new int[n];
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            if (nums[i] > m) {
                res++;
            } else {
                set.add(i);
            }
        }
        for (Integer idx : set) {
            int left = -1, right = -1;
            for (int i = idx - 1; i >= 0; i--) {
                if (!set.contains(i)) {
                    left = i;
                    break;
                }
            }
            boolean one = false, two = false;
            if (left == -1 || nums[left] + nums[idx] >= m * 2) {
                one = true;
            }
            for (int i = idx + 1; i < n; i++) {
                if (!set.contains(i)) {
                    right = i;
                    break;
                }
            }
            if (right == -1 || nums[right] + nums[idx] >= m * 2) {
                two = true;
            }
            if (one && two) {
                res++;
            }
        }
        System.out.println(res);
    }
}

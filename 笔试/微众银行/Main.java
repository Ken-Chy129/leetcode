package leetcode.笔试.微众银行;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/13 19:59
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        HashSet<Integer> set = new HashSet<>();
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                res.addFirst(nums[i]);
            }
        }
        for (Integer re : res) {
            System.out.print(re + " ");
        }
    }
}

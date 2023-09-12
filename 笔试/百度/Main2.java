package leetcode.笔试.百度;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/12 19:43
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = in.nextInt();
        }
        int cnt = 0;
        List<Integer> pos = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (nums[i] != i) {
                cnt++;
                pos.add(nums[i]);
            }
        }
        if (cnt == 0) {
            System.out.println("YES");
            System.out.println(0);
        } else if (cnt <= 2) {
            System.out.println("YES");
            System.out.println(1);
            System.out.print(pos.get(0) + " " + pos.get(1));
        } else {
            System.out.println("NO");
        }
    }
}

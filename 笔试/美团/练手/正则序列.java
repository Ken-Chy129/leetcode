package leetcode.笔试.美团.练手;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/10 22:19
 */
public class 正则序列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] nums = new int[20001];
        for (int i = 0; i < num; i++) {
            int key = in.nextInt();
            nums[key + 10000] = nums[key + 10000] + 1;
        }
        int regular = 1, ptr = 0, res = 0;
        while (num >= regular) {
            if (nums[ptr] == 0) {
                ptr++;
                continue;
            }
            while (nums[ptr] > 0) {
                res += Math.abs((ptr - 10000) - regular++);
                nums[ptr]--;
            }
            ptr++;
        }
        System.out.println(res);
    }
}

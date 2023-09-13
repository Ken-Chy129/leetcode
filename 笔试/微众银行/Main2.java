package leetcode.笔试.微众银行;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/13 20:24
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            nums.add(in.nextInt());
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.print(nums.removeFirst() + " ");
            nums.addLast(nums.removeFirst());
        }
        System.out.println(nums.removeFirst());
    }
}

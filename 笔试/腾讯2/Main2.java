package leetcode.笔试.腾讯2;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/15 20:17
 */
public class Main2 {

    public static void main(String[] args) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        for (int i = 0; i < n; i++) {
            queue.offer((long) in.nextInt());
        }
        for (int i = 0; i < k; i++) {
            long poll = queue.poll();
            if ((poll & 1) == 1) {
                queue.offer(poll << 1);
            } else {
                queue.offer((poll << 1) + 1);
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += queue.poll();
        }
        System.out.println(ans);
    }
}

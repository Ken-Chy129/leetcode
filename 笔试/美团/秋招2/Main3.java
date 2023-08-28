package leetcode.笔试.美团.秋招2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/26 10:29
 */
public class Main3 {

    public static void main(String[] args) {
        final long MOD = (long) (Math.pow(10, 9) + 7);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            priorityQueue.offer(in.nextLong());
        }
        long ans = 0;
        while (k-- != 0) {
            long a1 = priorityQueue.poll(), a2 = priorityQueue.poll();
            long x = 1, y = (a1 * a2) % MOD;
            priorityQueue.offer(x);
            priorityQueue.offer(y);
        }
        for (Long integer : priorityQueue) {
            ans = (ans + integer) % MOD;
        }
        System.out.println(ans);
    }
}

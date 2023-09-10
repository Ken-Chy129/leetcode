package leetcode.笔试.腾讯;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/10 21:20
 */
public class Main5 {

    static class Node {
        int num;
        int cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.cnt - o1.cnt;
            }
        });
        for (int i = 1; i <= n; i++) {
            int num = in.nextInt(), key = num, cnt = 0;
            while (num != 0) {
                if ((num & 1) == 1) {
                    break;
                }
                num >>= 1;
                cnt++;
            }
            queue.add(new Node(key, cnt));
        }
        long res = 0;
        final int mod = (int) (1e9 + 7);
        for (int i = 0; i < k; i++) {
            Node poll = queue.poll();
            poll.num -= Math.pow(2, poll.cnt);
            poll.cnt--;
            queue.offer(poll);
        }
        for (int i = 1; i <= n; i++) {
            res = (res + queue.poll().num) % mod;
        }
        System.out.println(res);
    }
}

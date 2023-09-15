package leetcode.笔试.腾讯2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/15 20:28
 */
public class Main3 {

    static class Node {
        int preIdx;
        int newPos;

        public Node(int preIdx, int newPos) {
            this.preIdx = preIdx;
            this.newPos = newPos;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), t = in.nextInt();
        int[] p = new int[n], v = new int[n];
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            v[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(n - i, p[i] + v[i] * t);
        }
        Arrays.sort(nodes, Comparator.comparing(o -> o.newPos));
        int ans = 0, idx = n;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].preIdx > n - i) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}

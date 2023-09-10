package leetcode.笔试.腾讯;

import java.util.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/10 20:13
 */
public class Main2 {

    static class Node {
        int key;
        long value;

        public Node(int key, long value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- != 0) {
            int n = in.nextInt();
            HashMap<Integer, Node> map = new HashMap<>();
            List<Node> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                Node node = new Node(i, in.nextInt());
                map.put(i, node);
                list.add(node);
            }
            list.sort(Comparator.comparing(o -> o.value));
            while (true) {
                if (n % 2 == 1) {
                    System.out.print(list.get(n / 2).value + " ");
                } else {
                    long sum = list.get(n / 2 - 1).value + list.get(n / 2).value;
                    if (sum % 2 == 0) {
                        System.out.print(sum / 2 + " ");
                    } else {
                        System.out.printf("%.01f ", sum / 2.0);
                    }
                }
                if (--n == 0) {
                    break;
                }
                list.remove(map.get(in.nextInt() - 1));
            }
            System.out.println();
        }
    }
}

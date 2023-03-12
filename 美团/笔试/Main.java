package leetcode.美团.笔试;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/11 18:52
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String tmp = in.next();
        char[] col = new char[n + 1];
        for (int i = 0; i < tmp.length(); i++) {
            col[i] = tmp.charAt(i);
        }
        int[] fa = new int[n + 1];
        ArrayList<Integer>[] sons = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            sons[i] = new ArrayList<>();
        }
        int[] blueMore = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            fa[i] = in.nextInt();
            sons[fa[i]].add(i);
        }
        int res = 0;
        for (int i = n; i >= 1; i--) {
            int size = sons[i].size();
            if (size == 0) {
                blueMore[i] = (col[i] == 'R') ? -1 : 1;
                res++;
            } else if (size == 1) {
                if (blueMore[sons[i].get(0)] == 0) {
                    blueMore[i] = (col[i] == 'R') ? -1 : 1;
                    res++;
                } else {
                    blueMore[i] = blueMore[sons[i].get(0)] + ((col[i] == 'R') ? -1 : 1);
                }
            } else {
                int son1 = sons[i].get(0);
                int son2 = sons[i].get(1);
                if (blueMore[son1] + blueMore[son2] == 0) {
                    blueMore[i] = (col[i] == 'R') ? -1 : 1;
                    res++;
                } else {
                    blueMore[i] = blueMore[son1] + blueMore[son2] + ((col[i] == 'R') ? -1 : 1);
                }
            }
        }
        System.out.println(res);
    }
}

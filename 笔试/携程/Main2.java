package leetcode.笔试.携程;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/15 19:12
 */
public class Main2 {
    
    static long l, r;
    
    static ArrayList<Integer>[] link;
    
    static char[] value;
    
    static long res;
    
    static boolean[] vis;
    
    static boolean first;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        l = in.nextLong();
        r = in.nextLong();
        in.nextLine();
        value = in.nextLine().toCharArray();
        link = new ArrayList[n + 1];
        vis = new boolean[n + 1];
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt(), v = in.nextInt();
            if (link[u] == null) {
                link[u] = new ArrayList<>();
            }
            if (link[v] == null) {
                link[v] = new ArrayList<>();
            }
            link[u].add(v);
            link[v].add(u);
        }
        for (int i = 1; i <= n; i++) {
            first = true;
            vis[i] = true;
            dfs(i, value[i - 1] - 48);
            vis[i] = false;
        }
        System.out.println(res);
    }

    private static void dfs(int root, long sum) {
        if (sum > r) {
            return;
        } else if (!first && sum >= l) {
            res++;
        }
        first = false;
        for (int i = 0; i < link[root].size(); i++) {
            int index = link[root].get(i);
            if (vis[index]) {
                continue;
            }
            long tmp = sum;
            int num = value[index - 1] - 48;
            tmp = (tmp << 1) + num;
            vis[index] = true;
            dfs(index, tmp);
            vis[index] = false;
        }
    }
}

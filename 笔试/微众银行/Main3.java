package leetcode.笔试.微众银行;

import java.util.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/13 20:29
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), s = in.nextInt(), t = in.nextInt();
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            edges.add(Arrays.asList(x, y));
            edges.add(Arrays.asList(y, x));
        }
        List<Integer> vis = new ArrayList<>();
        dfs(edges, s, vis);
        long cnt1 = vis.stream().mapToLong(x -> 1L).sum();
        if (vis.contains(t)) {
            System.out.println((int) (cnt1 * (cnt1 - 1) / 2));
            return;
        }
        dfs(edges, t, vis);
        long cnt2 = vis.stream().count() - cnt1;
        System.out.println((int) (cnt1 * cnt2));
    }
    private static void dfs(List<List<Integer>> edges, int from, List<Integer> vis) {
        vis.add(from);
        for (int neighbor : edges.get(from)) {
            if (!vis.contains(neighbor)) {
                dfs(edges, neighbor, vis);
            }
        }
    }
}

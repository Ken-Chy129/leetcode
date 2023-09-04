package leetcode.笔试.用友;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/4 20:13
 */
public class Main3 {

    public int minimumCost (int n, int[][] connections) {
        Arrays.sort(connections, Comparator.comparingInt(o -> o[2]));
        boolean[] vis = new boolean[n + 1];
        int cnt = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[connections[i][0]] && vis[connections[i][1]]) {
                continue;
            }
            if (!vis[connections[i][0]]) {
                vis[connections[i][0]] = true;
                cnt++;
            }
            if (!vis[connections[i][1]]) {
                vis[connections[i][1]] = true;
                cnt++;
            }
            ans += connections[i][2];
            if (cnt == n) {
                break;
            }
        }
        return ans;
    }
}

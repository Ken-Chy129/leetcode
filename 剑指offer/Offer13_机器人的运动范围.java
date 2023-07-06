package leetcode.剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/20 22:11
 */
public class Offer13_机器人的运动范围 {


    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        // 向右和向下的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; ++i) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || !isOk(tx, ty, k)) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }

    private boolean isOk(int m, int n, int k) {
        int res = 0;
        while (m != 0) {
            res += m % 10;
            m /= 10;
        }
        while (n != 0) {
            res += n % 10;
            n /= 10;
        }
        return res <= k;
    }

    public int movingCount2(int m, int n, int k) {
        boolean[][] vis = new boolean[m][n];
        return dfs(vis, 0, 0, m, n, k);
    }

    private int dfs(boolean[][] vis, int x, int y, int m, int n, int k) {
        if (x >= m || x < 0 || y >= n || y < 0 || vis[x][y] || !isOk(x, y, k)) {
            return 0;
        }
        vis[x][y] = true;
        return dfs(vis, x + 1, y, m, n, k) + dfs(vis, x, y + 1, m, n, k) + 1;
    }
}

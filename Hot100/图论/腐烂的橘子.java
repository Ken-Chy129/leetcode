package leetcode.Hot100.图论;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/22 16:36
 */
public class 腐烂的橘子 {

    public int orangesRotting(int[][] grid) {
        int res = 0, cnt = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    cnt++;
                }
            }
        }
        while (cnt != 0 && !queue.isEmpty()) {
            res++;
            for (int s = queue.size(); s > 0; s--) {
                int[] poll = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = poll[0] + dx[i];
                    int y = poll[1] + dy[i];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        cnt--;
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return cnt != 0 ? -1 : res;
    }
}

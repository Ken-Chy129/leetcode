package leetcode.笔试.网易;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/22 15:20
 */
public class Solution2 {

    int res;
    
    int dstX;
    
    int dstY;
    
    boolean[][] vis;
    
    public int getEstTime (int[][] map, int a_x, int a_y, int b_x, int b_y) {
        // write code here
        dstX = b_x;
        dstY = b_y;
        res = Integer.MAX_VALUE;
        vis = new boolean[map.length + 1][map.length + 1];
        dfs(map, a_x, a_y, 0);
        return res == Integer.MAX_VALUE ? -1 : ((res % 2 == 1) ? res / 2 + 1 : res / 2);
    }
    
    private void dfs(int[][] mp, int x, int y, int sum) {
        if (x >= mp.length || x < 0 || y >= mp[x].length || y < 0 || mp[x][y] == 0 || vis[x][y]) {
            return;
        }
        if (x == dstX && y == dstY) {
            res = Math.min(res, sum);
            return;
        }
        vis[x][y] = true;
        dfs(mp, x + 1, y, sum + 1);
        dfs(mp, x, y + 1, sum + 1);
        dfs(mp, x - 1, y, sum + 1);
        dfs(mp, x, y - 1, sum + 1);
        vis[x][y] = false;
    }
}

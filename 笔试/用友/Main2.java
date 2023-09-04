package leetcode.笔试.用友;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/4 20:21
 */
public class Main2 {

    int res = 0;
    
    public int maxValue (int[][] grid) {
        // write code here
        dfs(0, 0, 0, grid);
        return res;
    }

    private void dfs(int x, int y, int sum, int[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }
        sum += grid[x][y];
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            res = Math.max(res, sum);
            return;
        }
        dfs(x + 1, y, sum, grid);
        dfs(x, y + 1, sum, grid);
    }
}

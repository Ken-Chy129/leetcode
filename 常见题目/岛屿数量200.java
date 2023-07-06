package leetcode.常见题目;

/**
 * <pre>
 * <a href="https://leetcode.cn/problems/number-of-islands/">岛屿数量200</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/30 11:10
 */
public class 岛屿数量200 {

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    floodFill(grid, i, j); // 扩展，将周围联通的陆地全部用水淹没
                }
            }
        }
        return res;
    }

    private void floodFill(char[][] grid, int x, int y) {
        if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0 || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        floodFill(grid, x, y + 1);
        floodFill(grid, x, y - 1);
        floodFill(grid, x + 1, y);
        floodFill(grid, x - 1, y);
    }
}

package leetcode.Hot100.动态规划;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/24 23:00
 */
public class 不同路径 {

    int[][] mem;

    public int uniquePaths(int m, int n) {
        mem = new int[m + 1][n + 1];
        return dfs(m, n, 1, 1);
    }

    private int dfs(int m, int n, int x, int y) {
        if (x > m || y > n) {
            return 0;
        }
        if (mem[x][y] != 0) {
            return mem[x][y];
        }
        if (x == m && y == n) {
            mem[m][n] = 1;
            return 1;
        }
        mem[x][y] = dfs(m, n, x + 1, y) + dfs(m, n, x, y + 1);
        return mem[x][y];
    }

    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}

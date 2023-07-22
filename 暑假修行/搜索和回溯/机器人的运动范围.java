package leetcode.暑假修行.搜索和回溯;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/22 15:09
 */
public class 机器人的运动范围 {

    private boolean[][] visit;
    
    private int res;
    
    public int movingCount(int m, int n, int k) {
        visit = new boolean[m][n];
        dfs(m, n, 0, 0, k);
        return res;
    }
    
    private void dfs(int m, int n, int i, int j, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n || visit[i][j] || calculate(i) + calculate(j) > k) {
            return;
        }
        res++;
        visit[i][j] = true;
        dfs(m, n, i + 1, j, k);
        dfs(m, n, i - 1, j, k);
        dfs(m, n, i, j + 1, k);
        dfs(m, n, i, j - 1, k);
    }

    private int calculate(int i) {
        int res = 0;
        while (i != 0) {
            int r = i % 10;
            res += r;
            i /= 10;
        }
        return res;
    }
}

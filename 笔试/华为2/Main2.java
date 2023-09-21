package leetcode.笔试.华为2;

import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/20 19:03
 */
public class Main2 {
    
    private static int ans = Integer.MAX_VALUE;
    
    private static boolean[][] vis;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        int[][] gender = new int[m][n];
        vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                gender[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            if (gender[i][0] == 1) {
                dfs(i, 0, m, n, gender, 0);
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static void dfs(int x, int y, int m, int n, int[][] gender, int cnt) {
        if (x < 0 || x >= m || y < 0 || y >= n || vis[x][y] || gender[x][y] == 0 || cnt >= ans) {
            return;
        }
        if (y == n - 1) {
            ans = cnt;
            return;
        }
        vis[x][y] = true;
        dfs(x, y - 1, m, n, gender, cnt + 1);
        dfs(x, y + 1, m, n, gender, cnt + 1);
        dfs(x + 1, y, m, n, gender, cnt + 1);
        dfs(x - 1, y, m, n, gender, cnt + 1);
        vis[x][y] = false;
    }
}

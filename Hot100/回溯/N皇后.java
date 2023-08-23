package leetcode.Hot100.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/23 11:45
 */
public class N皇后 {

    List<List<String>> res = new ArrayList<>();
    boolean[] vis, leftOb, rightOb;

    public List<List<String>> solveNQueens(int n) {
        vis = new boolean[n];
        leftOb = new boolean[n << 1];
        rightOb = new boolean[n << 1];
        dfs(0, n, new int[n]);
        return res;
    }

    private void dfs(int row, int n, int[] queens) {
        if (row == n) {
            List<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] tmp = new char[n];
                Arrays.fill(tmp, '.');
                tmp[queens[i]] = 'Q';
                board.add(new String(tmp));
            }
            res.add(new ArrayList<>(board));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (vis[i] || leftOb[i - row + n] || rightOb[i + row]) {
                continue;
            }
            vis[i] = true;
            leftOb[i - row + n] = true;
            rightOb[i + row] = true;
            queens[row] = i;
            dfs(row + 1, n, queens);
            queens[row] = -1;
            vis[i] = false;
            leftOb[i - row + n] = false;
            rightOb[i + row] = false;
        }
    }
}

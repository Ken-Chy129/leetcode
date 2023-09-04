package leetcode.笔试.用友;

import java.util.Arrays;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/4 19:48
 */
public class Main {
    
    public int[] findAllCheapestPrice (int n, int[][] flights, int src) {
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE >> 1);
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            dp[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j] = Math.min(res[j], dp[src][i] + flights[src][j]);
            }
        }
        
        return res;
    }
}

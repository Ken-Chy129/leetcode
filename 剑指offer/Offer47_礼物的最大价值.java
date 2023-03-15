package leetcode.剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/15 15:19
 */
public class Offer47_礼物的最大价值 {

    public int maxValue(int[][] grid) {
        Queue<MyNode> queue = new LinkedList<>();
        queue.offer(new MyNode(0, 0, grid[0][0]));
        int res = 0;
        int lenY = grid.length - 1;
        int lenX = grid[0].length - 1;
        int[][] dp = new int[lenY + 1][lenX + 1];
        while (!queue.isEmpty()) {
            MyNode poll = queue.poll();
            if (poll.x == lenX && poll.y == lenY) {
                res = Math.max(res, poll.value);
            }
            if (poll.x < lenX) {
                if (dp[poll.y][poll.x + 1] < poll.value + grid[poll.y][poll.x + 1]) {
                    dp[poll.y][poll.x + 1] = poll.value + grid[poll.y][poll.x + 1];
                    queue.offer(new MyNode(poll.x + 1, poll.y, poll.value + grid[poll.y][poll.x + 1]));
                }
            }
            if (poll.y < lenY) {
                if (dp[poll.y + 1][poll.x] < poll.value + grid[poll.y + 1][poll.x]) {
                    dp[poll.y + 1][poll.x] = poll.value + grid[poll.y + 1][poll.x];
                    queue.offer(new MyNode(poll.x, poll.y + 1, poll.value + grid[poll.y + 1][poll.x]));
                }
            }
        }
        return res;
    }

    public int maxValue2(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        dfs(grid, dp, 0, 0, grid[0][0]);
        return dp[grid.length][grid[0].length];
    }

    private void dfs(int[][] grid, int[][] dp, int x, int y, int value) {
        if (y == grid.length && x == grid[0].length) {
            return;
        }
        if (x + 1 < grid.length && dp[x + 1][y] < grid[x + 1][y] + value) {
            dp[x + 1][y] = grid[x + 1][y] + value;
            dfs(grid, dp, x + 1, y, grid[x + 1][y] + value);
        }
        if (y + 1 < grid[0].length && dp[x][y + 1] < grid[x][y + 1] + value) {
            dp[x][y + 1] = grid[x][y + 1] + value;
            dfs(grid, dp, x, y + 1, grid[x][y + 1] + value);
        }
    }

    public static int maxValue3(int[][] grid) {
        int[] dp = new int[grid[0].length + 1];
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[i - 1].length; j++) {
                dp[j] = Math.max(dp[j - 1], dp[j]) + grid[i - 1][j - 1];
            }
        }
        return dp[grid[0].length];
    }

    public static void main(String[] args) {
        int[][] p = {{1,3,1}, {1,5,1}, {4,2,1}};
        maxValue3(p);
    }
}

class MyNode {
    int x;
    int y;
    int value;

    public MyNode(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}

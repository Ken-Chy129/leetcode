package leetcode.Hot100.回溯;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/23 0:42
 */
public class 单词搜索 {

    boolean[][] vis;   
    
    public boolean exist(char[][] board, String word) {
        vis = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (check(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, String word, int i, int j, int idx) {
        if (board[i][j] != word.charAt(idx)) {
            return false;
        } else if (idx == word.length() - 1) {
            return true;
        }
        vis[i][j] = true;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k], ny = j + dy[k];
            if (nx < 0 || nx > board.length || ny < 0 || ny > board[nx].length || vis[nx][ny]) {
                continue;
            }
            if (check(board, word, nx, ny, idx + 1)) {
                return true;
            }
        }
        vis[i][j] = false;
        return false;
    }
    
}

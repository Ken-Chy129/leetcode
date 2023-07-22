package leetcode.暑假修行.搜索和回溯;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/22 14:29
 */
public class 矩阵中的路径 {
    private boolean[][] visit;
    
    private boolean res;

    public boolean exist(char[][] board, String word) {
        visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    find(board, i, j, word, 0);
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void find(char[][] board, int i, int j, String word, int index) {
        if (res) {
            return;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || visit[i][j] || board[i][j] != word.charAt(index)) {
            return;
        }
        if (index == word.length() - 1) {
            res = true;
            return;
        }
        visit[i][j] = true;
        find(board, i + 1, j, word, index + 1);
        find(board, i - 1, j, word, index + 1);
        find(board, i, j + 1, word, index + 1);
        find(board, i, j - 1, word, index + 1);
        visit[i][j] = false;
    }
}

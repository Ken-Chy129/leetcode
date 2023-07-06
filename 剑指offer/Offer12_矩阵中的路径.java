package leetcode.剑指offer;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/20 21:07
 */
public class Offer12_矩阵中的路径 {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int ptr) {
        if (x >= board.length || x < 0 || y >= board[0].length || y <0 || word.charAt(ptr) != board[x][y]) {
            return false;
        }
        if (ptr == word.length() - 1) {
            return true;
        }
        board[x][y] = '\0';
        boolean res = dfs(board, x + 1, y, word, ptr + 1)
                || dfs(board, x - 1, y, word, ptr + 1)
                || dfs(board, x, y + 1, word, ptr + 1)
                || dfs(board, x, y - 1, word, ptr + 1);
        board[x][y] = word.charAt(ptr);
        return res;
    }
}

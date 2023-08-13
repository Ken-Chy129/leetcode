package leetcode.Hot100.矩阵;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/13 17:02
 */
public class 矩阵置零 {

    public void setZeroes(int[][] matrix) {
        // 使用matrix的第一行和第一列来存放对应行和列是否存在0（如果存在则置为0）
        // 那么原本行和列则需要额外的变量来保存是否存在0
        boolean col = false, row = false;
        int m = matrix.length, n = matrix[0].length;
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                col = true; // 第一列存在0
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                row = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (col) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (row) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}

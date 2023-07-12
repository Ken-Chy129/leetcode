package leetcode.暑假修行.模拟;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/12 13:12
 */
public class 顺时针打印矩阵 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int t = 0, b = matrix.length - 1, l = 0, r = matrix[0].length - 1, x = 0;
        int[] res = new int[(b + 1) * (r + 1)];
        while (true) {
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];
            }
            if (++t > b) {
                break;
            }
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r];
            }
            if (l > --r) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[b][i];
            }
            if (t > --b) {
                break;
            }
            for (int i = b; i >= t; i--) {
                res[x++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }
}

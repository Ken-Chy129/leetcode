package leetcode.数组;


/**
 * <pre>
 * <p>做法与逻辑矩阵相同</p>
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/4 16:22
 */
public class 螺旋矩阵II59 {
    public int[][] generateMatrix(int n) {
        int left = 0, right = n-1, top = 0, bottom = n-1, value = 1;
        int[][] res = new int[n][n];
        while (left <= right && top <= bottom) {
            for (int col=left; col<=right; col++) {
                res[top][col] = value++;
            }
            for (int row=top+1; row<=bottom; row++) {
                res[row][right] = value++;
            }
            if (left<=right && top<=bottom) {
                for (int col=right-1; col>=left; col--) {
                    res[bottom][col] = value++;
                }
                for (int row=bottom-1; row>top; row--) {
                    res[row][left] = value++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}

package leetcode.Hot100.矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/13 17:31
 */
public class 螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (left == right || top == bottom) {
                break;
            }
            for (int i = right - 1; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            for (int i = bottom - 1; i > top; i--) {
                res.add(matrix[i][left]);
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return res;
    }
}

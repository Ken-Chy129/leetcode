package leetcode.codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 题目链接：<a href="https://leetcode.cn/problems/spiral-matrix/">螺旋矩阵</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/20 20:54
 */
public class 螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        List<Integer> res = new ArrayList<>();
        while (left <= right && top <= bottom) {
            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            // ！！！！！
            // 只剩下一行或一列时则结束，否则会重复输出
            if (left == right || top == bottom) {
                break;
            }
            for (int col = right - 1; col >= left; col--) {
                res.add(matrix[bottom][col]);
            }
            for (int row = bottom; row > top; row--) {
                res.add(matrix[row][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}

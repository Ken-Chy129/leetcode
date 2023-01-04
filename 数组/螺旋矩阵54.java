package leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * <p>每一个循环处理一圈的数据，之后圈不停向内缩小</p>
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/4 15:48
 */
public class 螺旋矩阵54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            for (int column=left; column<=right; column++) {
                res.add(matrix[top][column]);
            }
            for (int row=top+1; row<=bottom; row++) {
                res.add(matrix[row][right]);
            }
            if (left<right && top<bottom) { // 避免剩下一行多列或一列多行时额外输出（因为这两种情况在上面已经输出了）
                for (int column=right-1; column>left; column--) {
                    res.add(matrix[bottom][column]);
                }
                for (int row=bottom; row>top; row--) {
                    res.add(matrix[row][left]);
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

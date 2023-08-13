package leetcode.Hot100.矩阵;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/13 23:40
 */
public class 旋转图像 {

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < (len + 1) >> 1; i++) {
            for (int j = i; j < len - i; j++) {
                int tmp = matrix[i][j]; // 行固定
                matrix[i][j] = matrix[len - j - 1][i]; // 列固定 
                matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1]; // 行固定
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1]; // 列固定
                matrix[j][len - i - 1] = tmp;
            }
        }
    }

    public void rotate2(int[][] matrix) {
        int len = matrix.length;
        // 水平翻转
        for (int i = 0; i < len; i++) { // 遍历每一列
            for (int j = 0; j < len >> 1; j++) {
                swap(matrix, j, i, len - j - 1, i);
            }
        }
        // 主对角线翻转
        for (int i = 0; i < len; i++) { // 遍历每一行
            for (int j = i + 1; j < len; j++) { // 遍历上三角形
                swap(matrix, i, j, j, i);
            }
        }
    }
    
    private void swap(int[][] nums, int i1, int j1, int i2, int j2) {
        int tmp = nums[i1][j1];
        nums[i1][j1] = nums[i2][j2];
        nums[i2][j2] = tmp;
    }
}

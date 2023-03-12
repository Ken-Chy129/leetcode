package leetcode.剑指offer;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/12 20:53
 */
public class Offer04_二维数组中的查找 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length == 0) {
                return false;
            }
            if (target < matrix[i][0]) {
                return false;
            }
            if (target > matrix[i][matrix[i].length - 1]) {
                continue;
            }
            int left = 0, right = matrix[i].length - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{}};
        System.out.println(a[0].length);
    }
}

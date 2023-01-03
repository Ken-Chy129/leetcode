package leetcode.数组.二分;

/**
 * <pre>
 * <p>求x平方根的简化版</p>
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/3 10:30
 */
public class 有效的完全平方数367 {
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        long mid, pow;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            pow = mid * mid;
            if (pow == num) {
                return true;
            } else if (pow < num) {
                left = (int) (mid + 1);
            } else {
                right = (int) (mid - 1);
            }
        }
        return false;
    }
}

package leetcode.剑指offer;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/12 21:07
 */
public class Offer11_旋转数组的最小数字 {

    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (numbers[mid] == numbers[right]) {
                right -= 1;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return numbers[left];
    }
}

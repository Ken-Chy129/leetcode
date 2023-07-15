package leetcode.暑假修行.查找;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/15 11:48
 */
public class 旋转数组的最小数字 {

    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (numbers[mid] == numbers[j]) {
                int res = numbers[i];
                for (int k = i + 1; k <= j; k++) {
                    if (numbers[k] < res) {
                        res = numbers[k];
                    }
                }
                return res;
            } else if (numbers[mid] < numbers[j]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return numbers[i];
    }
}

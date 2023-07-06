package leetcode.剑指offer;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/10 20:03
 */
public class Offer53_在排序数组中查找数字I {

    public int search(int[] nums, int target) {
        int pos = binary_left(nums, target);
        int res = 0;
        for (int i = pos; i > 0 && i < nums.length; i++) {
            if (nums[i] == target) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }

    private int binary_left(int[] nums, int key) {
        int left = 0, right = nums.length - 1, res = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == key) {
                res = right;
                right = mid - 1;
            } else if (nums[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}

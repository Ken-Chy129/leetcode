package leetcode.暑假修行.查找;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/15 10:04
 */
public class 在排序数组中查找数字 {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        // 查找左边界
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (l > nums.length || nums[r] != target) {
            return 0;
        }
        int left = r;
        r = nums.length - 1; // 左边界已经固定不需要换为0，缩小查找区间
        // 查找右边界
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - left + 1;
//        int j = helper(0, nums.length - 1, nums, target + 0.5);
//        if (j <= 0 || nums[j - 1] != target) return 0;
//        return j - helper(0, j, nums, target - 0.5);
    }
    
    private int helper(int l, int r, int[] nums, double target) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}

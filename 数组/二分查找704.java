package leetcode.数组;

/**
 * <pre>
 * <p></p>
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/2 11:44
 */
public class 二分查找704 {
    public int search1(int[] nums, int target) {
        return bisection(nums, 0, nums.length, target);
    }
    
    public int bisection(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;  
        } else if (nums[mid] < target) {
            return bisection(nums, mid+1, right, target);
        } else {
            return bisection(nums, left, mid-1, target);
        }
    }

    // 官方解法
    public int search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

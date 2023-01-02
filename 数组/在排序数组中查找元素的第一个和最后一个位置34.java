package leetcode.数组;

/**
 * <pre>
 * <p></p>
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/2 12:11
 */
public class 在排序数组中查找元素的第一个和最后一个位置34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        bisection(nums, 0, nums.length-1, target, result);
        return result;
    }
    
    public void bisection(int[] nums, int left, int right, int target, int[] result) {
        if (left > right) {
            return;
        }
        int mid = (right - left) / 2 + left;
        if (nums[mid] == target) {
            if (result[0] == -1) {
                result[0] = mid;
                result[1] = mid;
            } else if (mid < result[0]) {
                result[0] = mid;
            } else if(mid > result[1]) {
                result[1] = mid;
            }
            bisection(nums, mid+1, right, target, result);
            bisection(nums, left, mid-1, target, result);
        } else if (nums[mid] < target) {
            bisection(nums, mid+1, right, target, result);
        } else {
            bisection(nums, left, mid-1, target, result);
        }
    }

    // 使用两个二分分开查找左边界和右边界
    public int[] searchRange2(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
        return res;
    }
    
    public int binarySearch(int[] nums, int target, boolean leftOrRight) {
        int res = -1;
        int left = 0, right = nums.length - 1, mid;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(target < nums[mid])
                right = mid - 1;
            else if(target > nums[mid])
                left = mid + 1;
            else {
                res = mid;
                //处理target == nums[mid]
                if(leftOrRight)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return res;
    }
}

package leetcode.数组;

/**
 * <pre>
 * <p></p>
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/2 15:17
 */
public class 搜索插入位置35 {
    public int searchInsert(int[] nums, int target) {
        int left=0, right=nums.length-1, mid=0;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[mid] >= target) { // 如果mid位置所在的就是目的值则返回当前值，如果比目的值大则将目的值插在此处，原值后移
            return mid;
        } else {
            return mid + 1; // 如果mid所在值比目的值小，则将目的值插在mid后面一位
        }
    }
}

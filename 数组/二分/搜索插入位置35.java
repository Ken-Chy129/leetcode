package leetcode.数组.二分;

/**
 * <pre>
 * <p>此题其实就是二分查找后对结果进行一定的处理</p>
 * 
 * 需要将mid值进行保存，循环结束后mid值其实就是最后一次查询时指针所在的位置（即进行判断的位置）
 * 如果该位置正好是答案那么自然返回该位置就行了
 * 如果该位置不是答案，那么只有两种情况
 * 一种是最后一次判断的值比要找的数大，那么这个位置自然就是插入的位置
 * 最后一次判断的值小的话，自然就要将目标值放在它后面，即+1再返回
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

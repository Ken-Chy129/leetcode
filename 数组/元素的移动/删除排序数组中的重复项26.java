package leetcode.数组.元素的移动;

/**
 * <pre>
 * <p>删除重复元素需要记录出现过的元素，因为数组是有序排列的，所以只需要记住上一个元素的值即可</p>
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/3 11:26
 */
public class 删除排序数组中的重复项26 {
    public int removeDuplicates(int[] nums) {
        int pos = 1, last = nums[0];
        for (int i=1; i<nums.length; i++) {
            // 如果新的一个元素等于last说明是重复元素
            if (last != nums[i]) {
                nums[pos++] = nums[i]; // 非重复元素则保存
                last = nums[i]; // 并更新last
            }
        }
        return pos;
    }
}

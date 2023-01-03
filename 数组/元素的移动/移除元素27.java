package leetcode.数组.元素的移动;

/**
 * <pre>
 * <p>用O(1)的空间复杂度移除数组中某个值</p>
 * 最容易想到的莫过于从头到尾遍历数组，遇到目标值，则把该值后面的所有元素向前移动1位
 * 然而这样的方式时间复杂度时O(n^2)，并非最优解
 * 因为题目指出不需要考虑元素的顺序，也就是说移除了元素的那个位置不需要用它下一个元素替代
 * 那我们可以从后往前遍历数组，一遇到要删除的元素就用数组最后一个元素替代，时间复杂度只为O(n)
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/3 10:43
 */
public class 移除元素27 {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        // 为什么要从后往前遍历，因为所有元素是要集中在前面，而空白在后面
        // 而遇到要删除的元素使用最后的元素去替代的
        // 那么从后往前能够保证移到前面的一定是有值，因为后面的元素已经判断过了
        // 如果是从前往后遍历，那么用最后一个元素去替代的话他有可能也是要删除的元素
        for (int i=len-1; i>=0; i--) {
            if (nums[i] == val) {
                nums[i] = nums[len-1];
                len--;
            }
        }
        return len;
    }

    public int removeElement2(int[] nums, int val) {
        int pos = 0;
        for (int num : nums) {
            if (num != val) {
                nums[pos++] = num;
            }
        }
        return pos;
    }
}

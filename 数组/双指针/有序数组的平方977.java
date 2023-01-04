package leetcode.数组.双指针;

/**
 * <pre>
 * <p>使用两个指针分别指向位置 0 和 n-1，每次比较两个指针对应的数，选择较大的那个逆序放入答案并移动指针</p>
 * 也可以考虑将所有数平方后进行排序，那么排序的时间复杂度为O(nlogn)，空间为(logn)
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/4 10:19
 */
public class 有序数组的平方977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        // 左指针从最左边开始，右指针从最右边开始
        // 因为原先数组有序，负数越小其平方越大，所以对于负数来说平方后最大的值出现在最左侧
        int left = 0, right = nums.length-1, pos = nums.length-1;
        while (pos >= 0) { // 结果数组没有放完（原数组没有遍历完）
            if (nums[left] < 0) {
                if (-nums[left] < nums[right]) { // 负数的绝对值小，则pos放的是正数的平方，且右指针左移
                    res[pos--] = nums[right] * nums[right--];
                } else { // 负数的绝对值大，则pos放的是负数的平法，且左指针右移
                    res[pos--] = nums[left] * nums[left++];
                }
            } else { // 如果left所在的位置大于0了，那么接下来的位置其实都是有序的不需要再比较了，因为无序只出现在负数平方变大
                // 直接放入
                for (int i=0; i<=pos; i++) {
                    res[i] = nums[left] * nums[left++];
                }
                break;
            }
        }
        return res;
    }
}

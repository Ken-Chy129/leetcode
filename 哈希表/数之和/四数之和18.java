package leetcode.哈希表.数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * 解法同三数之和
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/8 16:44
 */
public class 四数之和18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first=0; first<nums.length-3; first++) {
            if (first > 0 && nums[first] == nums[first-1]) {
                continue;
            }
            // 剪枝
            // 接下来最小的四个数都大于目标值则结束
            if ((long) nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3] > target) {
                break;
            }
            // 这一轮这个取值和最大的三个数相加都小于目标值，则这一轮这个数不可能找到满足的情况
            if ((long) nums[first] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                continue;
            }
            for (int second=first+1; second<nums.length-2; second++) {
                if (second > first+1 && nums[second] == nums[second-1]) {
                    continue;
                }
                // 同理剪枝
                if ((long) nums[first] + nums[second] + nums[second + 1] + nums[second + 2] > target) {
                    break;
                }
                if ((long) nums[first] + nums[second] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    continue;
                }
                long aim = (long)target-nums[first]-nums[second];
                int fourth = nums.length-1;
                for (int third=second+1; third<nums.length-1; third++) {
                    if (third > second+1 && nums[third] == nums[third-1]) {
                        continue;
                    }
                    while (third < fourth && nums[third] + nums[fourth] > aim) {
                        fourth--;
                    }
                    if (third == fourth) {
                        break;
                    }
                    if (nums[third] + nums[fourth] == aim) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[first]);
                        tmp.add(nums[second]);
                        tmp.add(nums[third]);
                        tmp.add(nums[fourth]);
                        ans.add(tmp);
                    }
                }
            }
        }
        return ans;
    }
}

package leetcode.Hot100.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/22 20:35
 */
public class 全排列II {

    List<List<Integer>> res = new ArrayList<>();

    boolean[] vis;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        vis = new boolean[nums.length];
        dfs(nums, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, List<Integer> tmp) {
        if (nums.length == tmp.size()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && !vis[i - 1] && nums[i] == nums[i - 1])) {
                continue;
            }
            tmp.add(nums[i]);
            vis[i] = true;
            dfs(nums, tmp);
            vis[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        do {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        } while (nextPermutation(nums));
        return res;
    }

    private boolean nextPermutation(int[] nums) {
        int i, j;
        for (i = nums.length - 2; i > 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        for (j = nums.length - 1; j > 0; j--) {
            if (nums[j] > nums[i]) {
                break;
            }
        }
        if (i == 0 && j == 0) {
            return false;
        }
        swap(nums, i, j);
        reverse(nums, i + 1);
        return true;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}

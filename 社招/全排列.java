package leetcode.社招;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ken-Chy129
 * @date 2025/6/22
 */
public class 全排列 {

    private List<List<Integer>> res = new ArrayList<>();

    private List<Integer> list = new ArrayList<>();

    private boolean[] vis;

    public List<List<Integer>> permute(int[] nums) {
        vis = new boolean[nums.length];
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            list.add(nums[i]);
            dfs(nums);
            list.remove(list.size() - 1);
            vis[i] = false;
        }
    }
}

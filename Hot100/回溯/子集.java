package leetcode.Hot100.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/22 21:15
 */
public class 子集 {
    
    boolean[] vis;
    
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        vis = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<Integer> tmp, int idx) {
        res.add(new ArrayList<>(tmp));
        for (int i = idx; i < nums.length; i++) {
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            tmp.add(nums[i]);
            dfs(nums, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
            vis[i] = false;
        }
    }
}

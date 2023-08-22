package leetcode.Hot100.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/22 20:12
 */
public class 全排列 {

    List<List<Integer>> res = new ArrayList<>();
    
    boolean[] vis;
    
    public List<List<Integer>> permute(int[] nums) {
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
            if (vis[i]) {
                continue;
            }
            tmp.add(nums[i]);
            vis[i] = true;
            dfs(nums, tmp);
            vis[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
    
    
    
}

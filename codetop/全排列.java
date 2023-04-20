package leetcode.codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 题目链接：<a href="https://leetcode.cn/problems/permutations/">全排列</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/20 20:40
 */
public class 全排列 {

    List<List<Integer>> res = new ArrayList<>();
    
    List<Integer> list = new ArrayList<>();
    
    boolean[] vis;
    
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
            vis[i] = false;
            list.remove(list.size() - 1);
        }
    }
}

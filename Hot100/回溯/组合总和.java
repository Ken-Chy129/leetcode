package leetcode.Hot100.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/22 22:02
 */
public class 组合总和 {
    
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, new ArrayList<>(), 0, target);
        return res;
    }

    private void dfs(int[] candidates, int begin, List<Integer> tmp, int sum, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (candidates[i] + sum > target) {
                break;
            }
            tmp.add(candidates[i]);
            dfs(candidates, i, tmp, sum + candidates[i], target);
            tmp.remove(tmp.size() - 1);
        }
    }
}

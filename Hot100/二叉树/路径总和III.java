package leetcode.Hot100.二叉树;

import leetcode.分类刷题.树.TreeNode;

import java.util.HashMap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/17 16:18
 */
public class 路径总和III {

    HashMap<Long, Integer> map = new HashMap<>();
    
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        return dfs(root, 0, targetSum);
    }
    
    private int dfs(TreeNode root, long sum, int targetSum) {
        if (root == null) {
            return 0;
        }
        
        sum += root.val; // 计算当前前缀和
        int ret = map.getOrDefault(sum - targetSum, 0); // 计算到当前的路径中有多少满足的区间
        map.put(sum, map.getOrDefault(sum, 0) + 1); // 更新前缀和出现的次数
        ret += dfs(root.left, sum, targetSum); // 计算左节点路径
        ret += dfs(root.right, sum, targetSum); // 计算右节点路径
        map.put(sum, map.getOrDefault(sum, 0) - 1); // 结束该节点路径，回溯
        
        return ret;
    }
}

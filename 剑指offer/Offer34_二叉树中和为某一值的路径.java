package leetcode.剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/21 20:01
 */
public class Offer34_二叉树中和为某一值的路径 {

    List<List<Integer>> res;
    
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, 0, target, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int sum, int target, List<Integer> path) {
        if (root.left == null && root.right == null) {
            if (sum + root.val == target) {
                ArrayList<Integer> arrayList = new ArrayList<>(path);
                arrayList.add(root.val);
                res.add(arrayList);
            }
            return;
        }
        path.add(root.val);
        if (root.left != null) {
            dfs(root.left, sum + root.val, target, path);
        }
        if (root.right != null) {
            dfs(root.right, sum + root.val, target, path);
        }
        path.remove(path.size() - 1);
    }
}

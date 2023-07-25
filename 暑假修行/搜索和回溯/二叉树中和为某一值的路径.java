package leetcode.暑假修行.搜索和回溯;

import leetcode.分类刷题.树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/25 19:40
 */
public class 二叉树中和为某一值的路径 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(root.val);
        dfs(root, arrayList, root.val, target);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> path, int sum, int target) {
        if (root.left == null && root.right == null) {
            if (sum == target) {
                ArrayList<Integer> list = new ArrayList<>(path);
                res.add(list);
            }
            return;
        }
        if (root.left != null) {
            path.add(root.left.val);
            dfs(root.left, path, sum + root.left.val, target);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            dfs(root.right, path, sum + root.right.val, target);
            path.remove(path.size() - 1);
        }
    }
}

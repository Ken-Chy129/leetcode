package leetcode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 * 1.深度优先搜索
 * 2.广度优先搜索
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/15 23:46
 */
public class 二叉树的所有路径227 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        traversal(res, new StringBuilder(), root);
        return res;
    }
    
    public void traversal(List<String> res, StringBuilder path, TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            res.add(path.toString() + root.val); // 不能用path.append后再toString，会导致path值改变
            return;
        }
        int len = path.length();
        path.append(root.val).append("->");
        if (left != null) {
            traversal(res, path, left);
        }
        if (right != null) {
            traversal(res, path, right);
        }
        path.delete(len, path.length()); // 回溯
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        nodeQueue.offer(root);
        pathQueue.offer(String.valueOf(root.val));
        while (!nodeQueue.isEmpty()) {
            TreeNode treeNode = nodeQueue.poll();
            String path = pathQueue.poll();
            if (treeNode.left == null && treeNode.right == null) {
                res.add(path);
            }
            if (treeNode.left != null) {
                nodeQueue.offer(treeNode.left);
                pathQueue.offer(path + "->" + treeNode.left.val);
            }
            if (treeNode.right != null) {
                nodeQueue.offer(treeNode.right);
                pathQueue.offer(path + "->" + treeNode.right.val);
            }
        }
        return res;
    }
}

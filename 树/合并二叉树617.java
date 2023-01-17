package leetcode.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 1.深搜
 * 2.广搜
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/17 12:23
 */
public class 合并二叉树617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }

    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        Queue<TreeNode> treeQueue1 = new LinkedList<>();
        Queue<TreeNode> treeQueue2 = new LinkedList<>();
        Queue<TreeNode> mergedQueue = new LinkedList<>();
        treeQueue1.offer(root1);
        treeQueue2.offer(root2);
        TreeNode ans = new TreeNode(root1.val + root2.val);
        mergedQueue.offer(ans);
        while (!treeQueue1.isEmpty() || !treeQueue2.isEmpty()) {
            TreeNode treeNode1 = treeQueue1.poll();
            TreeNode treeNode2 = treeQueue2.poll();
            TreeNode root = mergedQueue.poll();
            TreeNode mergedNode1, mergedNode2;
            if (treeNode1.left == null) {
                mergedNode1 = treeNode2.left;
            } else if (treeNode2.left == null) {
                mergedNode1 = treeNode1.left;
            } else {
                treeQueue1.offer(treeNode1.left);
                treeQueue2.offer(treeNode2.left);
                mergedNode1 = new TreeNode(treeNode1.left.val + treeNode2.left.val);
                mergedQueue.offer(mergedNode1);
            }
            root.left = mergedNode1;
            if (treeNode1.right == null) {
                mergedNode2 = treeNode2.right;
            } else if (treeNode2.right == null) {
                mergedNode2 = treeNode1.right;
            } else {
                treeQueue1.offer(treeNode1.right);
                treeQueue2.offer(treeNode2.right);
                mergedNode2 = new TreeNode(treeNode1.right.val + treeNode2.right.val);
                mergedQueue.offer(mergedNode2);
            }
            root.right = mergedNode2;
        }
        return ans;
    }
}

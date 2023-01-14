package leetcode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 * 1.自诩观察我们会发现如果二叉树对称，那么进行左右根和右左根遍历得出的结果是相同的（根左右根右左也相同）
 * 2.递归：如果左右子树对称，那么它们的各自的左右子树都跟另一棵树的右左子树对称
 * 3.迭代实现
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/14 23:39
 */
public class 对称二叉树101 {
    public boolean isSymmetric(TreeNode root) {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        postorder1(leftList, root);
        postorder2(rightList, root);
        return leftList.equals(rightList);
    }

    public void postorder1(List<Integer> res, TreeNode root) {
        if (root == null) {
            res.add(null);
            return;
        }
        res.add(root.val);
        postorder1(res, root.left);
        postorder1(res, root.right);
    }

    public void postorder2(List<Integer> res, TreeNode root) {
        if (root == null) {
            res.add(null);
            return;
        }
        res.add(root.val);
        postorder2(res, root.right);
        postorder2(res, root.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        return check(root.left, root.right);
    }
    
    public boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val && check(node1.left, node2.right) && check(node1.right, node2.left);
    }
    
    // 迭代版
    public boolean isSymmetric3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.right);
            
            queue.offer(node2.left);
            queue.offer(node1.right);
        }
        return true;
    }
}

package leetcode.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 深搜：遍历完整棵树，记录最小的长度
 * 广搜：逐层往下，直到第一次遇到叶子节点则结束
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/15 1:01
 */
public class 二叉树的最小深度111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1; // 叶子节点
        }
        int min = Integer.MAX_VALUE;
        // 只有节点不等于null才能递归，否则传递null会直接返回0，会导致min等于0，那么另一个节点不管是否有值min都等于0
        // 即最后结果为1
        // 但其实如果一个节点的left和right只有一个为null的话，这个节点并非叶子节点，即其结果也不是1，而是另一个不为null的节点的到叶子节点的距离+1，为了避免null节点扰乱min的值（min是用来求两个有效子节点返回结果的最小值，而null返回的结果是无效的），则需要非null才能进入递归
        if (root.left != null) {
            min = Math.min(minDepth(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }
        return min + 1;
    }
    
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0){
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return ans;
                } else {
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                    size--;
                }
            }
            ans++;
        }
        return ans;
    }
}

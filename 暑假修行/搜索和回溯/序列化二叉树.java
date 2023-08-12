package leetcode.暑假修行.搜索和回溯;

import leetcode.分类刷题.树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/26 20:33
 */
public class 序列化二叉树 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                sb.append(poll.val).append(",");
                queue.offer(poll.left);
                queue.offer(poll.right);
            } else {
                sb.append("null,");
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        序列化二叉树 a = new 序列化二叉树();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(5);
        node.right = treeNode;
        System.out.println(a.serialize(node));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        int len = split.length, i = 1;
        if (len == 0 || len == 1 && "null".equals(split[0])) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (i == len) {
                break;
            }
            if (!"null".equals(split[i++])) {
                poll.left = new TreeNode(Integer.parseInt(split[i]));
                queue.offer(poll.left);
            }
            if (i == len) {
                break;
            }
            if (!"null".equals(split[i++])) {
                poll.right = new TreeNode(Integer.parseInt(split[i]));
                queue.offer(poll.right);
            }
        }
        return treeNode;
    }
}

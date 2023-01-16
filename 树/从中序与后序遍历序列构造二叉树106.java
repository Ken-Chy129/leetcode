package leetcode.树;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 递归：从后往前依次取出前缀遍历数组的值，以其作为分割点，不断将中序数组分割为右左子树
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/16 16:21
 */
public class 从中序与后序遍历序列构造二叉树106 {

    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        post_idx = postorder.length - 1;
        int index = 0;
        for (int val : inorder) {
            idx_map.put(val, index++);
        }
        return build(0, inorder.length-1);
    }
    
    public TreeNode build(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }

        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);

        // 下标减一
        post_idx--;
        // 先构造右子树，因为从后取后序遍历数组的值，去完根节点后接着最开始取到的就是最右边的节点
        root.right = build(index + 1, in_right);
        // 构造左子树
        root.left = build(in_left, index - 1);
        return root;
    }

}

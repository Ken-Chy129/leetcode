package leetcode.树;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 递归：从前往后依次取出前缀遍历数组的值，以其作为分割点，不断将中序数组分割为左右子树
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/16 17:24
 */
public class 从前序与中序遍历序列构造二叉树105 {
    
    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int index = 0;
        for (int val : inorder) {
            idx_map.put(val, index++);
        }
        return build(0, inorder.length-1);
    }
    
    public TreeNode build(int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }

        int val = preorder[pre_idx++];
        TreeNode root = new TreeNode(val);
        
        Integer index = idx_map.get(val);
        
        root.left = build(in_left, index-1);
        root.right = build(index+1, in_right);
        
        return root;
    }
}

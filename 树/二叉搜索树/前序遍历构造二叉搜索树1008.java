package leetcode.树.二叉搜索树;

import java.util.*;

/**
 * <pre>
 * <a href="https://leetcode.cn/problems/construct-binary-search-tree-from-preorder-traversal/">前序遍历构造二叉搜索树</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/29 21:07
 */
public class 前序遍历构造二叉搜索树1008 {
    
    int indexx;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] preorder, int min, int max) {
        if (indexx == preorder.length) {
            return null;
        }
        int val = preorder[indexx];
        if (val > max || val < min) {
            return null;
        }
        indexx++;
        TreeNode node = new TreeNode(val);
        node.left = dfs(preorder, min, val);
        node.right = dfs(preorder, val, max);
        return node;
    }
    
    public TreeNode bstFromPreorder2(int[] preorder) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        deque.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode top = deque.peekLast();
            int val = preorder[i];
            while (!deque.isEmpty() && deque.peekLast().val < val) {
                top = deque.removeLast();
            }
            TreeNode node = new TreeNode(val);
            if (top.val < val) { // 只要进了循环，出来top.val一定小于val
                top.right = node;
            } else { // 说明没进循环
                top.left = node;
            } 
            deque.add(node);
        }
        return root;
    }

    public TreeNode bstFromPreorder3(int[] preorder) {
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, map, 0, 0, inorder.length - 1);
    }
    
    private TreeNode dfs(int[] preorder, HashMap<Integer, Integer> map, int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[root]);
        int index = map.get(preorder[root]);
        node.left = dfs(preorder, map, root + 1, left, index - 1);
        node.right = dfs(preorder, map, root + index - left + 1, index + 1, right);
        return node;
    } 
    
}

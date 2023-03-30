package leetcode.分类刷题.树;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/30 15:58
 */
public class 树的构造 {
    
    // 前序遍历和中序遍历构造二叉树
    public TreeNode constructFromPreIn(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return partition(map, preorder, 0, 0, inorder.length - 1);
    }

    private TreeNode partition(HashMap<Integer, Integer> map, int[] pre, int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(pre[root]); // 根
        // 找到前序遍历结点在中序遍历数组中的位置，分割出左右两棵子树
        Integer index = map.get(pre[root]);
        // 前序遍历中是根、左、右
        node.left = partition(map, pre, root + 1, left, index - 1); // 左
        // index - left表示的就是左子树的节点个数，加上之后就得到了遍历完左子树后开始遍历右子树时root在前序遍历数组的下标
        node.right = partition(map, pre, root + index - left + 1, index + 1, right); // 右
        return node;
    }

    // 后序遍历和中序遍历构造二叉树
    public TreeNode constructFromPostIn(int[] postorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return partition2(map, postorder, inorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode partition2(HashMap<Integer, Integer> map, int[] pre, int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(pre[root]); // 根
        // 找到后序遍历结点在中序遍历数组中的位置，分割出左右两棵子树
        Integer index = map.get(pre[root]);
        // index从数组尾部遍历，所以顺序分别是根、右、左
        node.right = partition2(map, pre, root - 1, index + 1, right); // 左
        // right - index 表示左子树的节点数量，减去之后得到的值就是开始构造右子树时在后序遍历数组的下标
        node.left = partition2(map, pre, root - (right - index) - 1, left, index - 1); // 右
        return node;
    }
    
    // 前序遍历和后序遍历构造二叉树
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return partition3(map, preorder, 0, preorder.length - 1, 0);
    }
    
    private TreeNode partition3(HashMap<Integer, Integer> map, int[] pre, int preLeft, int preRight, int postLeft) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode node = new TreeNode(pre[preLeft]);
        if (preLeft == preRight) {
            return node; // 如果已经没有下一个结点则直接返回
        }
        int index = map.get(pre[preLeft + 1]); // 计算下一个结点在后序数组的位置
        int num = index - postLeft + 1; // 前序数组的下一个结点就是左子树的根节点，在后序数组中找到他的位置，因为后序数组是左右根，其左边的节点数量就是子树的结点数量
        // 遍历左子树
        node.left = partition3(map, pre, preLeft + 1, preLeft + num, postLeft);
        // 遍历右子树
        node.right = partition3(map, pre, preLeft + num + 1, preRight, index + 1);
        return node;
    }
}

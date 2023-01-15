package leetcode.树;

/**
 * <pre>
 * 1.自顶向下递归，不断求左右节点的高度判断差值是否大于1(每个节点的高度会被重复计算)
 * 2.自底向上递归，采用后续遍历，从最下的节点开始，求其左右节点高度，判断是否平衡，如果不平衡则整棵树不平衡，如果平衡则继续往上判断
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/15 14:33
 */
public class 平衡二叉树110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) { // 判断当前节点左右子树是否平衡
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right); // 如果平衡则继续往下判断左右子节点
    }
    
    public int getHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(getHeight(treeNode.left), getHeight(treeNode.right)) + 1;
    }

    public boolean isBalanced2(TreeNode root) {
        return getHeight2(root) >= 0;
    }

    public int getHeight2(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftHeight = getHeight2(treeNode.left);
        int rightHeight = getHeight2(treeNode.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // 相当于后续遍历，到最下面一个节点后判断其左右子树是否平衡，不平衡则返回-1，如果子节点的高度已经是-1了则肯定不平衡了直接返回-1
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

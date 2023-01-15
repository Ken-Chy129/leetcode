package leetcode.树;


/**
 * <pre>
 * 1.二分查找+位运算
 * 2.递归：如果子树是完全二叉树则直接返回子树的节点数，如果不是完全二叉树则继续判断其左右子树
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/15 10:54
 */
public class 完全二叉树的节点个数222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode node = root;
        int h = 0;
        while (node.left != null) {
            h++;
            node = node.left;
        } // 求出最大高度
        int left = 1 << h, right = (1 << (h+1)) - 1; // 最下一层节点的标号
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (check(root, h, mid)) {
                // 该节点存在，则往右查找
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
    
    public boolean check(TreeNode root, int height, int index) {
        int bits = 1 << (height-1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            // &运算可以用来求一个数中的指定位，将要判断的那一位置为1，其他位为0，然后用这个数和指定数想与，结果如果为0就说明对应位置为0，结果如果不为0就说明对应位置为1
            // 此处我们要判断index的第二位到结束的每一位是0还是1来决定是往左走还是往右走，这里用bits来控制
            // 最开始bits=1<<(height-1)其实就是一个首位为1(因为是height-1所以这里的首位对应的是index的第二位)，其他都为0的数
            // 然后每次判断后就对bits右移1位，即然后1后移以判断index后面的位是否为1
            // 比如index=5，即101，首位不用看，第二位0就说明从根节点先像左走，第三位为1就说明第二步是往右走即可到达结点5
            if ((index & bits) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
 
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftHeight = 0, rightHeight = 0;
        while (left != null) {
            left = left.left;
            leftHeight++;
        }
        while (right != null) {
            right = right.right;
            rightHeight++;
        }
        if (leftHeight == rightHeight) {
            return (1 << (leftHeight+1)) - 1;
        }
        return countNodes2(root.left) + countNodes2(root.right) + 1;
    }
}


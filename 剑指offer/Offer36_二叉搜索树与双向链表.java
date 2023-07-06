package leetcode.剑指offer;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/21 20:37
 */
public class Offer36_二叉搜索树与双向链表 {

    Node prev, head;
    
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inorderTravel(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

    private void inorderTravel(Node root) {
        if (root == null) {
            return;
        }
        inorderTravel(root.left);
        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
        }
        root.left = prev;
        prev = root;
        inorderTravel(root.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}

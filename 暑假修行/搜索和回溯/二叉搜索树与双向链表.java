package leetcode.暑假修行.搜索和回溯;


/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/25 20:46
 */
public class 二叉搜索树与双向链表 {

    Node head, prev;
    
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        preorder(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

    private void preorder(Node root) {
        if (root == null) {
            return;
        }
        preorder(root.left);
        if (prev != null) {
            prev.right = root;
        } else {
            head = root;
        }
        root.left = prev;
        prev = root;
        preorder(root.right);
    }
}

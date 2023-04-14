package leetcode.数据结构;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/13 22:33
 */
public class BST {
    
    private Node root;
    
    static class Node {
        private int val;
        
        private Node left;
        
        private Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    
    public boolean find(int key) {
        Node p = root;
        while (p != null) {
            if (key > p.val) {
                p = p.right;
            } else if (key < p.val) {
                p = p.left;
            } else {
                return true;
            }
        }
        return false;
    }
    
    public void insert(int key) throws Exception {
        if (root == null) {
            root = new Node(key);
            return;
        }
        Node p = root, parent = null;
        while (true) {
            if (p == null) {
                if (key > parent.val) {
                    parent.right = new Node(key);
                } else {
                    parent.left = new Node(key);
                }
                return;
            }
            parent = p;
            if (key > p.val) {
                p = p.right;
            } else if (key < p.val) {
                p = p.left;
            } else {
                throw new Exception("插入失败");
            }
        }
    }
    
    public boolean delete(int key) {
        Node p = root, parent = null;
        // 查找key位置
        while (p != null) {
            if (key > p.val) {
                parent = p;
                p = p.right;
            } else if (key < p.val) {
                parent = p;
                p = p.left;
            } else {
                break;
            }
        }
        if (p == null) {
            return false;
        }
        // 待删除的节点没有左节点，无论有无右节点都有如下情况
        if (p.left == null) {
            if (p == root) {
                root = p.right;
            } else if (p == parent.left) { // 要删除的节点是父节点的左节点
                parent.left = p.right;
            } else { // 要删除的节点是父节点的右节点
                parent.right = p.right;
            }
        } else if (p.right == null) { // 要删除的节点有左节点，没有右节点
            if (p == root) {
                root = p.left;
            } else if (p == parent.left) {
                parent.left = p.left;
            } else {
                parent.right = p.left;
            } 
        } else { // 要删除的节点有左节点也有右节点
            // 寻找第一个大于待删除节点的节点，用其替换待删除的节点
            // 要寻找第一个大于待删除的节点只需要从其右节点一路向左走
            Node nextParent = p;
            Node next = p.right;
            while (next.left != null) {
                nextParent = next;
                next = next.left;
            }
            p.val = next.val;
            if (nextParent == p) {
                nextParent.right = next.right;
            } else {
                nextParent.left = next.right;
            }
        }
        return true;
    }
}

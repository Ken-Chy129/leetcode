package leetcode.社招;

import leetcode.社招.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ken-Chy129
 * @date 2025/5/22
 */
public class N叉树的后序遍历 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return res;
        }
        for (Node child : root.children) {
            preorder(child);
        }
        res.add(root.val);
        return res;
    }
}

package leetcode.社招.common;

import java.util.List;

/**
 * @author Ken-Chy129
 * @date 2025/5/22
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

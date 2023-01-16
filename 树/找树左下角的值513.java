package leetcode.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 1.广搜，每一层遍历，找到最左边的节点记录下值
 * 2.深搜，找到最深的一层就将结果记录下来，先遍历的是左节点，所以右节点如果同样高度则不会覆盖掉左节点的值，保证了最终找到的是最左边的节点
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/16 13:44
 */
public class 找树左下角的值513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = root.val;
        boolean flag = true; // 此处也可以不使用flag，而是每次offer入队的时候先入right节点，那么最后一次poll出来的节点就是当层最左边的节点
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                    if (flag) {
                        ans = poll.left.val;
                        flag = false;
                    }
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    if (flag) {
                        ans = poll.right.val;
                        flag = false;
                    }
                }
            }
            flag = true;
        }
        return ans;
    }
    
    int res = 0;
    int maxHeight = -1;

    public int findBottomLeftValue2(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    
    public void dfs(TreeNode root, int height) {
        if (root.left == null && root.right == null) {
            if (height > maxHeight) {
                maxHeight = height;
                res = root.val;
            }
            return;
        }
        if (root.left != null) {
            dfs(root.left, height+1);
        }
        if (root.right != null) {
            dfs(root.right, height+1);
        }
    }
}

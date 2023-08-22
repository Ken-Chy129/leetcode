package leetcode.Hot100.图论;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/22 17:30
 */
public class 课程表 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses]; // 入度表
        List<List<Integer>> adj = new ArrayList<>(); // 邻接表
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            in[prerequisite[0]]++;
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            numCourses--;
            for (Integer idx : adj.get(poll)) {
                if (--in[idx] == 0) {
                    queue.offer(idx);
                }
            }
        }
        return numCourses == 0;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[] flag = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adj, flag, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adj, int[] flag, int idx) {
        if (flag[idx] == 1) {
            return false;
        }
        if (flag[idx] == -1) {
            return true;
        }
        flag[idx] = 1;
        for (Integer integer : adj.get(idx)) {
            if (!dfs(adj, flag, integer)) {
                return false;
            }
        }
        flag[idx] = -1;
        return true;
    }
}

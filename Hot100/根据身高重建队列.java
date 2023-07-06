package leetcode.Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <pre>
 * 题目链接：<a href="https://leetcode.cn/problems/queue-reconstruction-by-height/">根据身高重建队列</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/21 22:37
 */
public class 根据身高重建队列 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int[][] res = new int[people.length][];
        for (int i = 0; i < people.length; i++) {
            int tallerNum = people[i][1], j = 0;
            while (tallerNum != 0) {
                if (res[j] == null || res[j][0] >= people[i][0]) {
                    tallerNum--;
                }
                j++;
            }
            while (res[j] != null) {
                j++;
            }
            res[j] = people[i];
        }
        return res;
    }

    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[people.length][]);
    }

}

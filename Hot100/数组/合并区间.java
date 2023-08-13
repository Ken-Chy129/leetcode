package leetcode.Hot100.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/13 11:05
 */
public class 合并区间 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; ) {
            int start = intervals[i][0], end = intervals[i][1];
            while (++i < intervals.length) {
                if (intervals[i][0] <= end) {
                    end = Math.max(end, intervals[i][1]);
                } else {
                    break;
                }
            }
            res.add(new int[]{start, end});
        }
        return res.toArray(new int[0][0]);
    }
}

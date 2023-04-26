package leetcode.分类刷题.贪心;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 题目链接：<a href="https://leetcode.cn/problems/partition-labels/">划分字母区间</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/26 15:22
 */
public class 划分字母区间 {

    public List<Integer> partitionLabels(String s) {
        int[] pos = new int[26];
        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'] = i;
        }
        int begin = 0, end = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, pos[s.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - begin + 1);
                begin = i + 1;
            }
        }
        return res;
    }
}

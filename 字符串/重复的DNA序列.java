package leetcode.字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * <pre>
 * 题目链接：<a href="https://leetcode.cn/problems/repeated-dna-sequences/">重复的DNA序列</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/26 16:14
 */
public class 重复的DNA序列 {

    // 滑动窗口+字符串哈希优化（字符串哈希需要O(L)的时间复杂度，转成整形则可以优化为O(1)）
    public List<String> findRepeatedDnaSequences(String s) {
        char[] chars = s.toCharArray();
        // 因为DNA序列只有ACGT四种，可以转为四进制整数存储
        // 记录每一位的值
        int[] bits = new int[s.length()];
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'A' -> bits[i] = 0;
                case 'C' -> bits[i] = 1;
                case 'G' -> bits[i] = 2;
                case 'T' -> bits[i] = 3;
            }
        }
        // 移动时的除数
        int div = (int) Math.pow(4, 9);
        int left = 0, right = 0;
        int num = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        while (right < s.length()) {
            num = num * 4 + bits[right];
            if (right - left == 9) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (map.get(num) == 2) {
                    res.add(s.substring(left, right + 1));
                }
                num -= bits[left] * div;
                left++;
            }
            right++;
        }
        return res;
    }
}

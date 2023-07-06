package leetcode.codetop;

import java.util.HashMap;

/**
 * <pre>
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">无重复字符的最长子串</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/9 15:12
 */
public class 无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0, begin = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) { // 如果该字符已经存在
                Integer index = map.get(s.charAt(i));
                if (index >= begin) { // 而且是在本次字符串中存在，则本次字符串长度记录结束
                    res = Math.max(res, i - begin); // 计算出长度
                    begin = index + 1; // 更新新的起点为出现重复字符的位置的下一位
                }
            }
            map.put(s.charAt(i), i);
        }
        if (s.length() - begin > res) {
            res = s.length() - begin;
        }
        return res;
    }
}

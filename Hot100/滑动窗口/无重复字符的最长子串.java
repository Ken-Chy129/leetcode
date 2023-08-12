package leetcode.Hot100.滑动窗口;

import java.util.HashMap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/12 18:23
 */
public class 无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0, i, j;
        for (i = 0, j = 0; j < chars.length; j++) {
            Integer pos = map.get(chars[j]);
            if (pos != null && pos >= i) {
                res = Math.max(res, j - i);
                i = pos + 1;
            }
            map.put(chars[j], j);
        }
        res = Math.max(res, chars.length - i);
        return res;
    }
}

package leetcode.社招;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ken-Chy129
 * @date 2025/6/20
 */
public class 无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        int res = 0, i, j;
        Map<Character, Integer> map = new HashMap<>();
        for (i = 0, j = 0; j < s.length(); j++) {
            Integer pos = map.get(s.charAt(j));
            if (pos != null && pos >= i) {
                res = Math.max(res, j - i);
                i = pos + 1;
            }
            map.put(s.charAt(j), j);
        }
        res = Math.max(res, j - i);
        return res;
    }
}

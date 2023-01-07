package leetcode.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 异位词等价于对两个字符串进行排序后相等
 * 也可以使用哈希表维护一个字符串存在的字符和出现的次数，再遍历另一个字符串对第一个出现的次数逐渐减少，若少于0则不相等
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/7 11:04
 */
public class 有效的字母异位词242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i=0; i<t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
            if (map.get(t.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }

}

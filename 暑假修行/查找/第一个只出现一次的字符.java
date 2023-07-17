package leetcode.暑假修行.查找;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/17 11:57
 */
public class 第一个只出现一次的字符 {

    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), true);
            } else {
                map.put(s.charAt(i), false);
            }
        }
        for (Character character : map.keySet()) {
            if (map.get(character)) {
                return character;
            }
        }
        return ' ';
    }
}

package leetcode.剑指offer;

import java.util.LinkedHashMap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/12 21:47
 */
public class Offer50_第一个只出现一次的字符 {

    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.containsKey(s.charAt(i)));
        }
        for (Character character : map.keySet()) {
            if (!map.get(character)) {
                return character;
            }
        }
        return ' ';
    }
}

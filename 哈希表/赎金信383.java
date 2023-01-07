package leetcode.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 想要让magazine中的单词可以组成ransomNote中的单词，那么magazine要涵盖ransomNote，字母出现的大于等于ransomNote
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/7 11:21
 */
public class 赎金信383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i=0; i<ransomNote.length(); i++) {
            Integer cnt = map.getOrDefault(ransomNote.charAt(i), 0);
            if (cnt == 0) {
                return false;
            }
            map.put(ransomNote.charAt(i), cnt - 1);
        }
        return true;
    }
}

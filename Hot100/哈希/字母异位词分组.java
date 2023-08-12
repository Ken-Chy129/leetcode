package leetcode.Hot100.哈希;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/12 12:11
 */
public class 字母异位词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] cnt = new int[26];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                cnt[str.charAt(i) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (cnt[j] != 0) {
                    sb.append((char) ('a' + j)).append(cnt[j]);
                }
            }
            String key = sb.toString();
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(str);
            map.put(key, value);
        }
        return new ArrayList<>(map.values());
    }
}

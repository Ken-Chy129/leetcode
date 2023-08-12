package leetcode.Hot100.滑动窗口;

import java.util.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/12 20:07
 */
public class 找到字符串中所有字母异位词 {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return Collections.emptyList();
        }
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int[] cnt = new int[26];
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        for (int i = 0; i < pLen; i++) {
            cnt[pp[i] - 'a']++;
            cnt[ss[i] - 'a']--;
        }
        int differ = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                differ++;
            }
        }
        if (differ == 0) {
            res.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            if (cnt[ss[i] - 'a'] == -1) {
                differ--;
            } else if (cnt[ss[i] - 'a'] == 0) {
                differ++;
            }
            cnt[ss[i] - 'a']++;
            if (cnt[ss[i + pLen] - 'a'] == 1) {
                differ--;
            } else if (cnt[ss[i + pLen] - 'a'] == 0) {
                differ++;
            }
            cnt[ss[i + pLen] - 'a']--;
            if (differ == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}

package leetcode.数组.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * <p></p>
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/4 13:45
 */
public class 最小覆盖子串76 {

    private Map<Character, Integer> cnt = new HashMap<>();
    private Map<Character, Integer> ori = new HashMap<>();
    
    public String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        // 设置需求表，即每个字符需要出现多少次
        for (int i=0; i<len2; i++) {
            ori.put(t.charAt(i), ori.getOrDefault(t.charAt(i), 0) + 1);
        }
        int pos1 = 0, pos2 = 0; // 左、右指针
        int ansL = -1, ansR = -1, len = Integer.MAX_VALUE;
        while (pos2 < len1) {
            // 如果当前字符是t表中的字符，则需要增加cnt哈希表中该字符的数量
            if (ori.containsKey(s.charAt(pos2))) {
                cnt.put(s.charAt(pos2), cnt.getOrDefault(s.charAt(pos2), 0) + 1);
            }
            // 如果当前窗口符合要求（通过判断cnt哈希表中的数量是否满足需求表中规定的数量）
            // 如果满足则尝试收缩左边界以找到最小的满足的情况
            while (check() && pos1 <= pos2) {
                if (pos2 - pos1 + 1 < len) { // 如果新的窗口更小，则更新结果
                    len = pos2 - pos1 + 1;
                    ansL = pos1;
                    ansR = pos2;
                }
                if (ori.containsKey(s.charAt(pos1))) { // 如果值是t中的值则需要将map中的数量减少，以便判断是否还符合需求
                    cnt.put(s.charAt(pos1), cnt.getOrDefault(s.charAt(pos1), 0) - 1);
                }
                pos1++; // 窗口左边界不断收缩
            }
            // 窗口右边界不断扩展
            pos2++;
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR+1);
    }
    
    public boolean check() {
        for (Map.Entry<Character, Integer> entry : ori.entrySet()) {
            if (cnt.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}

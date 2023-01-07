package leetcode.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * 维护一个长度为p.length()的滑动窗口和一个数组记录窗口内给个字母出现的次数，每次移动时窗口左临界的字母移去，加上右临界的字母
 * 每次移动后判断窗口数组和p产生的数组是否相同
 * 由于比较数组需要O(n)的时间复杂度，可以使用一个dis变量记录当前两个数组不同字符的数量，dis为0时可选，时间复杂度优化为O(1)
 * </pre>
 * 
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/7 13:20
 */
public class 找到字符串中所有字母异位词438 {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        int lens = s.length();
        int lenp = p.length();
        if (lens < lenp) {
            return list;
        }
        char[] sc = new char[26];
        char[] pc = new char[26];
        for (int i=0; i<lenp; i++) {
            sc[s.charAt(i)-'a']++;
            pc[p.charAt(i)-'a']++;
        }
        for (int i=0; i<lens-lenp; i++) {
            if (Arrays.equals(sc, pc)) {
                list.add(i);
            }
            sc[s.charAt(i)-'a']--;
            sc[s.charAt(i+lenp)-'a']++;
        }
        if(Arrays.equals(sc, pc)) {
            list.add(lens-lenp);
        }
        return list;
    }

    // 优化
    public static List<Integer> findAnagrams2(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        int lens = s.length();
        int lenp = p.length();
        if (lens < lenp) {
            return list;
        }
        int dis = 0;
        int[] count = new int[26]; // 维护的是两个字符串对于每个字母的数量差，正数表示p字符串多了几个，负数表示p字符串少了几个
        for (int i=0; i<lenp; i++) {
            count[s.charAt(i)-'a']++;
            count[p.charAt(i)-'a']--;
        }
        for (int i=0; i<26; i++) {
            if (count[i] != 0) {
                dis++;
            }
        }
        for (int i=0; i<lens-lenp; i++) {
            if (dis == 0) {
                list.add(i);
            }
            int i1 = s.charAt(i) - 'a';
            if (count[i1] == 0) { // 某个字母数量差等于0时减去移除该元素会导致多一个不满足要求
                dis++;
            } else if (count[i1] == 1) {
                dis--;
            }
            count[i1]--;
            int i2 = s.charAt(i + lenp) - 'a';
            if (count[i2] == -1) { // 某个字母数量差等于0时减去移除该元素会导致多一个不满足要求
                dis--;
            } else if (count[i2] == 0) {
                dis++;
            }
            count[i2]++;
        }
        if (dis==0) {
            list.add(lens-lenp);
        }
        return list;
    }
}

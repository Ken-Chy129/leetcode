package leetcode.哈希表;

import java.util.*;

/**
 * <pre>
 * 这道题主要提示我们哈希表的key不要被局限，之前时两个字符串进行比较，所以采用出现的每个字母作为键，出现次数作为值。但是对于本题，要比较的是多个字符串，那我们需要把握字母异位词的特征，属于字母异位词的多个字符串排序后相同或对他们使用字母-次数的表示方式相同，所以我们可以对字符串排序后存入map(n*k*logk)，也可以对每个字符串求出各个字符数量作为键存入(n*(k+26))
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/7 11:29
 */
public class 字母异位词分组49 {
    
    // 无脑解法，化成两个字符串比较问题两两比较，因为要在两重循环里面比较
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i< strs.length; i++) {
            if (strs[i] == null) {
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            for (int j=i+1; j<strs.length; j++) {
                if (strs[j] != null && strs[i].length() == strs[j].length()) {
                    map.clear();
                    for (int k=0; k<strs[i].length(); k++) {
                        map.put(strs[i].charAt(k), map.getOrDefault(strs[i].charAt(k), 0) + 1);
                    }
                    boolean flag = true;
                    for (int k=0; k<strs[j].length(); k++) {
                        if (map.getOrDefault(strs[j].charAt(k), 0) == 0) {
                            flag = false;
                            break;
                        }
                        map.put(strs[j].charAt(k), map.getOrDefault(strs[j].charAt(k), 0) - 1);
                    }
                    if (flag) {
                        list.add(strs[j]);
                        strs[j] = null;
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
    
    // 排序
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String tmp = new String(chars);
            List<String> list = map.getOrDefault(tmp, new ArrayList<>());
            list.add(str);
            map.put(tmp, list);
        }
        return new ArrayList<>(map.values());
    }

    // 计数
    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] letters = new int[26];
            for (int i=0; i<str.length(); i++) {
                letters[str.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<26; i++) {
                if (letters[i] != 0) {
                    sb.append('a' + i);
                    sb.append(letters[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}

package leetcode.Hot100.子串;

import java.util.HashMap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/13 1:04
 */
public class 最小覆盖子串 {

    public String minWindow(String s, String t) {
        int[] cnt1 = new int[60];
        int[] cnt2 = new int[60];
        int differ = 0;
        for (int i = 0; i < t.length(); i++) {
            if (++cnt2[getId(t.charAt(i))] == 1) {
                differ++;
            }
        }
        String ans = "";
        for (int i = 0, j = 0; j < s.length(); j++) {
            int idx1 = getId(s.charAt(j));
            if (++cnt1[idx1] == cnt2[idx1]) {
                differ--;
            }
            while (i < j) {
                int idx2 = getId(s.charAt(i));
                if (cnt1[idx2] > cnt2[idx2]) {
                    cnt2[idx2]--;
                    i++;
                } else {
                    break;
                }
                if (differ == 0 && (ans.length() == 0 || ans.length() > j - i + 1)) {
                    ans = s.substring(i, j - i + 1);
                }
            }
        }
        return ans;
    }

    private int getId(Character x) {
        return x >= 'a' ? x - 'a' : x - 'A' + 26;
    }
}

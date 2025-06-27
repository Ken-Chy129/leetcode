package leetcode.社招;

/**
 * @author Ken-Chy129
 * @date 2025/6/22
 */
public class 最长回文子串 {

    public String longestPalindrome(String s) {
        int maxLength = 0, left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int l = i, r = i; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r); l--, r++) {
                if (maxLength < r - l + 1) {
                    maxLength = r - l + 1;
                    left = l;
                    right = r;
                }
            }
            for (int l = i, r = i + 1; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r); l--, r++) {
                if (maxLength < r - l + 1) {
                    maxLength = r - l + 1;
                    left = l;
                    right = r;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}

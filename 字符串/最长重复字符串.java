package leetcode.字符串;

import java.util.HashSet;

/**
 * <pre>
 * 题目链接：<a href="https://leetcode.cn/problems/longest-duplicate-substring/">最长重复字符串</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/26 16:28
 */
public class 最长重复字符串 {

    final int radix1 = 31;
    final int radix2 = 41;
    final int mod1 = 2000000007;
    final int mod2 = 2000000009;
    int[] bits;
    
    public String longestDupSubstring(String s) {
        int left = 1, right = s.length() - 1;
        bits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            bits[i] = s.charAt(i) - 'a';
        }
        int index;
        String res = "";
        while (left <= right) {
            int mid = (right + left) >> 1;
            if ((index = check(mid)) != -1) {
                left = mid + 1;
                res = s.substring(index, index + mid);
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
    
    private int check(int len) {
        int left = 0, right = 0;
        long num1 = 0, num2 = 0;
        HashSet<Long> set = new HashSet<>();
        long div1 = pow(radix1, len - 1, mod1);
        long div2 = pow(radix2, len - 1, mod2);
        while (right < bits.length) {
            num1 = ((num1 * radix1 % mod1) + bits[right]) % mod1; 
            num2 = ((num2 * radix2 % mod2) + bits[right]) % mod2;
            if (num1 < 0) {
                num1 += mod1;
            }
            if (num2 < 0) {
                num2 += mod2;
            }
            if (right - left == len - 1) {
                long num = num1 + num2;
                if (set.contains(num)) {
                    return left;
                } else {
                    set.add(num);
                }
                num1 = (num1 - bits[left] * div1 % mod1 + mod1) % mod1;
                num2 = (num2 - bits[left] * div2 % mod2 + mod2) % mod2;
                left++;
            }
            right++;
        }
        return -1;
    }
    
    private long pow(int x, int m, int mod) {
        long res = 1;
        while (m != 0) {
            if ((m & 1) == 1) {
                res = res * x % mod;
            }
            m >>= 1;
            x = x * x % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        最长重复字符串 s = new 最长重复字符串();
        s.longestDupSubstring("banana");
    }
}

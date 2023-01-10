package leetcode.字符串;

import java.util.Arrays;

/**
 * <pre>
 * 1.枚举：从长度为1的字符串开始尝试，判断是否满足，不满足则不断增加长度直至长度达到字符串的一半
 * 2.字符串匹配：将两个原字符串前后拼接后再减去首字符和尾字符，如果原字符串可以由子串重复构成则拼接后的字符串一定包含原字符串
 *      假设原字符串s由x重复组成，即s=xx(最少两个x，甚至更多)，那么两个s则为xxxx(甚至更多)，删去首尾只能去除掉两个重复项，那么最少还剩下两个，一定可以构成s，所以如果可以由子串重复构成那么两个s拼接后的一定包含s
 * 3.kmp：既然能字符串匹配那么就可以采用kmp优化
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/10 22:41
 */
public class 重复的子字符串459 {

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i=1; i*2<=n; i++) { // i表示重复字符串的长度
            if (n % i == 0) { // 不是成倍数的一定不满足，直接剪枝
                boolean match = true;
                for (int j=i; j<n; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    // 字符串匹配
    public boolean repeatedSubstringPattern2(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
    
    // kmp算法
    public boolean repeatedSubstringPattern3(String s) {
        return kmp(s + s, s);
    }

    public boolean kmp(String query, String pattern) {
        int n = query.length();
        int m = pattern.length();
        int[] fail = new int[m];
        Arrays.fill(fail, -1);
        for (int i = 1; i < m; ++i) {
            int j = fail[i - 1];
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                j = fail[j];
            }
            if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        int match = -1;
        for (int i = 1; i < n - 1; ++i) {
            while (match != -1 && pattern.charAt(match + 1) != query.charAt(i)) {
                match = fail[match];
            }
            if (pattern.charAt(match + 1) == query.charAt(i)) {
                ++match;
                if (match == m - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

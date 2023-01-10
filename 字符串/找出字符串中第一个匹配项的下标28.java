package leetcode.字符串;

/**
 * <pre>
 * kmp算法:https://www.zhihu.com/question/21923021/answer/281346746
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/10 16:55
 */
public class 找出字符串中第一个匹配项的下标28 {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        for (int i=0; i<=hLen-nLen; i++) {
            // 此处调用substring需要的空间复杂度较高，可手动一位一位判断
            if (haystack.substring(i, i+nLen).equals(needle)){
                return i;
            }
        }
        return -1;
    }
    
    // 不调用api的做法
    public int strStr2(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        for (int i=0; i<=hLen-nLen; i++) {
            int a=i, b=0;
            while (b < nLen && haystack.charAt(a) == needle.charAt(b)) {
                a++;
                b++;
            }
            if (b == nLen) {
                return i;
            }
        }
        return -1;
    }
    
    // kmp算法
    // kmp算法其实核心就是遇到不匹配的位置时不用重新重头开始判断
    // 只需要让模式字符串的指针回到 当前已经匹配了的字符串 的相同前后缀最大长度 所在的位置即可
    // 比如到第j位不匹配，而从第0位到第j-1位的字符串的前缀和后缀最大的相交长度是x
    // 那么i指针不动，j指针回到x即可，因为0到x的这一串字符串（前缀）会和指针i前面的那x位字符串是相同的（因为那个原本就是模式字符串的后缀，而x这个长度的前后缀是相同的，所以这两部分相同），那么只需要从x+1位继续判断即可
    public static int strStr3(String haystack, String needle) {
        int hLen = haystack.length(), nLen = needle.length();
        if (nLen == 0) {
            return 0;
        }
        int[] next = new int[nLen];
        // 构造next数组，next[j]表示字符串在第j+1位不匹配时指针要跳转的位置
        // 其实也就是等于从0到j的字符串的公共前缀后缀的最长长度，即next[2]就是长度为3的字符串的公共前后缀最长长度
        // 求next数组的过程其实也是一个字符串匹配过程
        // 两个指针一个最开始指向第二位（遍历后缀，因为后缀不能包括第一个字符），第一个指向第一位，遍历前缀
        for (int i=1, j=0; i<nLen; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j-1]; // 如果新的一位不相等则j回退，再与i比较，逻辑等同于kmp，直到相等或者j已经到最前一位
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            // 注意如果前面循环是在相等时结束的，那么到这里j++，已经到了下一位，正好表示的就是最大长度(因为长度是下标+1)，也正好是表示回退的位置，因为前面是相等的，那么回退的自然是相等的下一位，
            // 如果是j=0结束的，那么如果第0位相等则还是会进入j++，不相等那么最大长度自然为0
            next[i] = j; // i是后缀，所以i的当前的指向就是这次判断的字符串的长度
        }
        int i=0, j=0;
        while (i < hLen && j < nLen) {
            if (j >= 0 && haystack.charAt(i) != needle.charAt(j)) {
                if (j == 0) {
                    i++;
                } else {
                    j = next[j-1];
                }
            } else if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
        }
        if (j == nLen) {
            return i-j;
        }
        return -1;
    }

}

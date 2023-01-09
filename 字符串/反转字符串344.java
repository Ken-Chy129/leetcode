package leetcode.字符串;

/**
 * <pre>
 * 双指针指向头和尾，不断交换并向中间靠拢 
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/9 11:06
 */
public class 反转字符串344 {
    public void reverseString(char[] s) {
        int len = s.length;
        char tmp;
        for (int i=0; i<len/2; i++) {
            tmp = s[len-i-1];
            s[len-i-1] = s[i];
            s[i] = tmp;
        }
    }
}

package leetcode.字符串;

/**
 * <pre>
 * 每隔k个反转k个，末尾不够k个时全部反转
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/9 11:16
 */
public class 反转字符串II541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i=0; i<s.length(); i+=2*k) {
            reserve(chars, i, Math.min(i + k, s.length()));
        }
        return new String(chars);
    }
    
    public void reserve(char[] chars, int begin, int end) {
        int len = end - begin;
        char tmp;
        for (int i=0; i<len/2; i++) {
            tmp = chars[end-i-1];
            chars[end-i-1] = chars[begin+i];
            chars[begin+i] = tmp;
        }
    }
}

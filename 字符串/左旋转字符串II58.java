package leetcode.字符串;

/**
 * <pre>
 * 1.字符串切片api
 * 2.遍历字符串
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @date 2023/1/10 16:33
 */
public class 左旋转字符串II58 {
    
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
    
    public String reverseLeftWords2(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i=n; i<n+s.length(); i++) {
            sb.append(s.charAt(i % s.length())); // 使用取余简化，不需要对两部分分开处理
        }
        return sb.toString();
    }
}

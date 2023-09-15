package leetcode.笔试.腾讯2;

import java.util.HashSet;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/15 20:59
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- != 0) {
            int n = in.nextInt();
            HashSet<String> set = new HashSet<>();
            boolean res = false;
            for (int i = 0; i < n; i++) {
                String s = in.next();
                int len = s.length();
                for (int j = 0; j < len; j++) {
                    if (set.contains(s)) {
                        res = true;
                        break;
                    }
                    set.add(s);
                    s = s.substring(1, len) + s.charAt(0);
                }
                if (res) {
                    for (int j = i + 1; j < n; j++) {
                        in.next();
                    }
                    break;
                }
            }
            System.out.println(res ? "YES" : "NO");
        }
    }
}

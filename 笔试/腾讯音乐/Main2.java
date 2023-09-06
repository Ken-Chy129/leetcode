package leetcode.笔试.腾讯音乐;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/6 19:10
 */
public class Main2 {

    public int kawaiiStrings (int n) {
        // write code here
        if (n <= 3) {
            return 0;
        }
        final int mod = (int) (Math.pow(10, 9) + 7);
        long[] cute = new long[n];
        long[] notCute = new long[n];
        cute[3] = 3;
        notCute[3] = 2;
        for (int i = 4; i < n; i++) {
            cute[i] = (((cute[i - 1] * 3) % mod) * (i - 1) % mod + (notCute[i - 1] * 3) % mod) % mod;
            notCute[i] = (((notCute[i - 1] * 3) % mod) * (i - 1) % mod + (cute[i - 1] * 3) % mod) % mod; 
        }
        return (int)cute[n - 1];
    }
}

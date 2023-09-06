package leetcode.笔试.腾讯音乐;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/6 20:04
 */
public class Main3 {

    public int cntOfTrees (int n) {
        // write code here
        long cnt = 1;
        final int mod = (int) (Math.pow(10, 9) + 7);
        // good[i] = notGood[i - 1] * i
        // notGood[i] = good[i - 1]
        for (int i = 0; i < n; i++) {
            if (n % 2 == 1) {
                cnt = cnt * 2 % mod;
            }
        }
        long num = 1, num2, num3;
        for (int i = 2; i <= n; i++) {
            num = num * i % mod;
        }
        num2 = num * (n + 1) % mod;
        num3 = num;
        for (int i = n + 1; i <= 2*n; i++) {
            num3 = num3 * i % mod;
        }
        long res = num3 / (num * num2 % mod) / 2;
        return (int)res;
    }
}

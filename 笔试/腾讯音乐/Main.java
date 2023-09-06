package leetcode.笔试.腾讯音乐;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/6 18:57
 */
public class Main {

    public int perfectPair (int[] arr) {
        // write code here
        int n = arr.length;
        long[][] multi = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    continue;
                }
                multi[i][j] = (long)arr[i] * (long)arr[j];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    continue;
                }
                String str = String.valueOf(multi[i][j]);
                int cnt = 0;
                for (int k = 0; k < str.length(); k++) {
                    if (str.charAt(k) != '0') {
                        cnt++;
                    }
                    if (cnt > 1) {
                        break;
                    }
                }
                if (cnt == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.perfectPair(new int[]{25, 2, 1, 16});
    }
}

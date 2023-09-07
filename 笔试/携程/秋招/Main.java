package leetcode.笔试.携程.秋招;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/7 18:58
 */
public class Main {

    static List<List<Integer>> res = new ArrayList<>();

    static boolean[] vis;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n];
        for (int i = 1; i <= n; i++) {
            num[i - 1] = i;
        }
        vis = new boolean[n];
        dfs(num, new ArrayList<>(), 0);
        int ans = 0;
        for (List<Integer> re : res) {
            int sum = re.get(0);
            boolean isPrime = false;
            for (int i = 1; i < re.size(); i++) {
                sum += re.get(i);
                if (checkPrime(sum)) {
                    isPrime = true;
                    break;
                }
                sum -= re.get(i - 1);
            }
            if (!isPrime) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean checkPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(int[] num, List<Integer> tmp, int cnt) {
        if (cnt == num.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (vis[i]) {
                continue;
            }
            tmp.add(num[i]);
            vis[i] = true;
            dfs(num, tmp, cnt + 1);
            vis[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }

}

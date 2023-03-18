package leetcode.美团.笔试2;


import java.util.Scanner;

public class Main {

    static int i = 1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), a = in.nextInt(), b = in.nextInt();
        int[][] mp = new int[1005][1005];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt(), y = in.nextInt();
            mp[x][y]++;
        }
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                mp[i][j] = mp[i - 1][j] + mp[i][j - 1] + mp[i][j] - mp[i - 1][j - 1];
            }
        }
        int res = 0;
        for (int i = b + 1; i <= 1000; i++) {
            for (int j = a + 1; j <= 1000; j++) {
                int tmp = mp[i][j] - mp[i - b - 1][j] - mp[i][j - a - 1] + mp[i - b - 1][j - a - 1];
                res = Math.max(tmp, res);
            }
        }
        System.out.print(res);
    }
}

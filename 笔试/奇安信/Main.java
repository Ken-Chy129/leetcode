package leetcode.笔试.奇安信;

import java.util.Arrays;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/16 16:23
 */
public class Main {

    public int[] getLuckyNum (int[][] nums) {
        // write code here
        int[][] cnts = new int[34][2];
        for (int i = 0; i < 34; i++) {
            cnts[i][0] = i;
        }
        for (int[] num : nums) {
            for (int i : num) {
                cnts[i][1]++;
            }
        }
        Arrays.sort(cnts, 1, cnts.length, (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int[] res = new int[7];
        for (int i = 0; i < 7; i++) {
            res[i] = cnts[i + 1][0];
        }
        Arrays.sort(res);
        return res;
    }
}

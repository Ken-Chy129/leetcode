package leetcode.笔试.知乎;

import java.util.Arrays;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/16 14:26
 */
public class Main2 {

    public int prize (int[] scores) {
        // write code here
        int[] prize = new int[scores.length];
        Arrays.fill(prize, 1);
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[i - 1]) {
                prize[i] = prize[i - 1] + 1;
            } else if (scores[i] < scores[i - 1]) {
                prize[i - 1] = Math.max(prize[i - 1], prize[i] + 1);
                for (int j = i - 1; j > 0; j--) {
                    if (prize[j] >= prize[j - 1] && scores[j] < scores[j - 1]) {
                        prize[j - 1] = prize[j] + 1;
                    }
                }
            }
        }
        return Arrays.stream(prize).sum();
    }
}

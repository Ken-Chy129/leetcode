package leetcode.笔试.大疆;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/13 18:48
 */
public class Main {
    public int[] ThreeDigitNumbers (int[] selectedDigits) {
        Arrays.sort(selectedDigits);
        int len = selectedDigits.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < len; k++) {
                    if (k == j || k == i) {
                        continue;
                    }
                    res.add(selectedDigits[i] * 100 + selectedDigits[j] * 10 + selectedDigits[k]);
                }
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] ints = main.ThreeDigitNumbers(new int[]{1, 2, 3,4});
        System.out.println(Arrays.toString(ints));
    }
}

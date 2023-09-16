package leetcode.笔试.奇安信;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/16 16:39
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String[] split = in.next().split(",");
        int[] pa = new int[split.length];
        for (int i = 0; i < pa.length; i++) {
            pa[i] = Integer.parseInt(split[i]);
        }
        List<Integer> list = new ArrayList<>();
        while (in.hasNext()) {
            String[] line = in.next().split(",");
            int idx = Integer.parseInt(line[0]), num = Integer.parseInt(line[1]);
            int val = Integer.MIN_VALUE, res = idx;
            while (idx != -1) {
                if (val < (num ^ idx)) {
                    val = num ^ idx;
                    res = idx;
                }
                idx = pa[idx];
            }
            list.add(res);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer).append(",");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}

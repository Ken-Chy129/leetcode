package leetcode.笔试.大疆;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/13 19:31
 */
public class Main2 {

    public int[] calculateFinalPositi(String instructions) {
        long u = 0, d = 0, l = 0, r = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'U' || c == 'u') {
                u++;
            }
            if (c == 'D' || c == 'd') {
                d++;
            }
            if (c == 'L' || c == 'l') {
                l++;
            }
            if (c == 'R' || c == 'r') {
                r++;
            }
        }
        return new int[]{(int) (r - l), (int) (d - u)};
    }

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        for (int ruddllurrr : main2.calculateFinalPositi("")) {
            System.out.println(ruddllurrr);
        }
    }
}

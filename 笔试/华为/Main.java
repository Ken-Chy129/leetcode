package leetcode.笔试.华为;

import java.util.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/5/6 18:59
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[] bits = new boolean[n];
        in.nextLine();
        toBits(bits, in.nextLine());
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < bits.length; i++) {
            if (!bits[i]) {
                set.add(i);
                list.add(i);
            }
        }
        if (list.isEmpty()) {
            System.out.println(0);
            return;
        }
        boolean left = false, right = false;
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < list.size(); j++) {
                int index = list.get(j) - i;
                if (index < 0 || set.contains(index)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                right = true;
                r = i;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < list.size(); j++) {
                int index = list.get(j) + i;
                if (index >= bits.length || set.contains(index)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                left = true;
                l = i;
                break;
            }
        }
        if (left && right) {
            System.out.println(2);
        } else if (left || right) {
            System.out.println(1);
        } else {
            System.out.println(0);
            return;
        }
        if (right) {
            System.out.println("+" + r);
            for (int i = r; i < bits.length + r; i++) {
                if (set.contains(i)) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
        if (left) {
            System.out.println("-" + l);
            for (int i = -l; i < bits.length - l; i++) {
                if (set.contains(i)) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
        }
    }

    private static int toBits(boolean[] bits, String ori) {
        String[] s = ori.split(" ");
        int tol = 0;
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
            for (int k = 2; k <= 5; k++) {
                int num = getDecimal(s[i].charAt(k));
                int cnt = 0;
                int index = (i * 16) + (k - 2) * 4 + 3;
                while (cnt <= 3 && tol < bits.length) {
                    if ((num & 1) == 1 && index < bits.length) {
                        bits[index] = true;
                        tol++;
                    }
                    num >>= 1;
                    cnt++;
                    index--;
                }
            }
        }
        return 0;
    }

    private static int getDecimal(char x) {
        return x > 64 ? x - 'A' + 10: x - '0';
    }
}

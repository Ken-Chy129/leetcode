package leetcode;


import java.util.HashSet;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s = in.nextLine().toCharArray();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length; i++) {
            for (int j = i + 1; j < s.length; j++) {
                if (s[i] != '0') {
                    int num = (s[i] - 48 ) * 10 + (s[j] - 48);
                    if (!set.contains(num)) {
                        if (!set.isEmpty()) {
                            System.out.print(",");
                        }
                        System.out.print(num);
                    }
                    set.add(num);
                }
                if (s[j] != '0') {
                    int num = (s[j] - 48) * 10 + (s[i] - 48);
                    if (!set.contains(num)) {
                        if (!set.isEmpty()) {
                            System.out.print(",");
                        }
                        System.out.print(num);
                    }
                    set.add(num);
                }
            }
        }
    }
}

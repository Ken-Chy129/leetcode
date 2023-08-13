package leetcode.笔试.美的;


import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s = in.nextLine().toCharArray();
        int start = 0, res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            if (!map.containsKey(s[i])) {
                map.put(s[i], i);
            } else {
                int index = map.get(s[i]);
                if (index >= start) {
                    map.put(s[i], i);
                    res = Math.max(res, i - start);
                    start = index + 1;
                }
            } 
        }
        System.out.println(res);
    }
}

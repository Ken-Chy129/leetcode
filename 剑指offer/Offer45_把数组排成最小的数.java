package leetcode.剑指offer;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/22 21:16
 */
public class Offer45_把数组排成最小的数 {

    public static String minNumber(int[] nums) {
        List<String> list = new ArrayList<>(Arrays.stream(nums).parallel().mapToObj(String::valueOf).toList());
        list.sort((o1, o2) -> o1.concat(o2).compareTo(o2.concat(o1)));
        return String.join("", list);
    }

    public static void main(String[] args) {
        minNumber(new int[]{3,30,34,5,9});
    }
}

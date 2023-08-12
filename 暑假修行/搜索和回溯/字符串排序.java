package leetcode.暑假修行.搜索和回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/26 21:31
 */
public class 字符串排序 {

    List<String> res = new ArrayList<>();
    
    boolean[] visit;
    
    char[] ss;
    
    public String[] permutation(String s) {
        visit = new boolean[s.length()];
        ss = s.toCharArray();
        Arrays.sort(ss);
        dfs(0, new StringBuilder());
        return res.toArray(new String[0]);
    }

    private void dfs(int i, StringBuilder now) {
        if (i == ss.length) {
            res.add(now.toString());
        }
        for (int j = 0; j < ss.length; j++) {
            if (visit[j] || (j > 0 && !visit[j - 1] && ss[j] == ss[j - 1])) {
                continue;
            }
            now.append(ss[j]);
            visit[j] = true;
            dfs(i + 1, now);
            visit[j] = false;
            now.deleteCharAt(i);
        }
    }

    public String[] permutation2(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        List<String> res = new ArrayList<>();
        do {
            res.add(new String(chars));
        } while (nextPermutation(chars));
        return res.toArray(new String[0]);
    }
    
    private boolean nextPermutation(char[] ss) {
        int i = ss.length - 2;
        while (i >= 0 && ss[i] > ss[i + 1]) {
            i--; // 找到较小数（此时右边一定是降序的）
        }
        if (i < 0) {
            return false;
        }
        int j = ss.length - 1;
        while (j >= 0 && ss[i] > ss[j]) {
            j--; // 找到较大数（一定能找得到，因为上一个循环的结束就是i+1大于等于i，或者i<0，而i<0已经return// ）
        }
        swap(ss, i, j); // 交换较小数和较大数
        reverse(ss, i + 1);// 翻转i后面的序列，因为原本都是降序的，所以会变为升序（这样才是下一个序列（最小））
        return true;
    }

    public void reverse(char[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(char[] nums, int left, int right) {
        char tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}

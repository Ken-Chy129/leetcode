package leetcode.分类刷题.动态规划;

import java.util.Arrays;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/14 22:56
 */
public class 最长上升子序列 {

    public int LIS (int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(0);
    }

    public int LIS2 (int[] arr) {
        int[] increase = new int[arr.length];
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i] > increase[index]) {
                increase[++index] = arr[i];
            } else {
                increase[binarySearch(increase, index, arr[i])] = arr[i];
            } 
        }
        return index + 1;
    }
    
    private int binarySearch(int[] arr, int last, int key) {
        int i = 0, j = last;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                i = mid + 1;
            } else {
                j = mid - 1;
            } 
        }
        return i;
    }
}

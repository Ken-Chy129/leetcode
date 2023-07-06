package leetcode.网易;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/22 13:51
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param price int整型一维数组 宝石价格列表
     * @param k int整型 行囊个数
     * @return int整型
     */
    public int putGems (int[] price, int k) {
        // write code here
        int[][] max = new int[price.length][k + 1];
        int[][] min = new int[price.length][k + 1];
        for (int i = 0; i < price.length; i++) {
            for (int j = 0; j < k + 1; j++) {
                min[i][j] = 1000000;
            }
        }
        for (int i = 0; i < price.length; i++) {
            max[i][1] = price[0] + price[i];
            min[i][1] = max[i][1];
        }
        for (int i = 1; i < price.length; i++) {
            for (int j = 2; j <= k && j <= i + 1; j++) {
                max[i][j] = Math.max(max[i - 1][j] - price[i - 1] + price[i], max[i - 1][j - 1] + 2 * price[i]);
                min[i][j] = Math.min(min[i - 1][j] - price[i - 1] + price[i], min[i - 1][j - 1] + 2 * price[i]);
            }
        }
        return max[price.length - 1][k] - min[price.length - 1][k];
    }
}

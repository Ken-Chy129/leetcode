package leetcode.社招;

/**
 * @author Ken-Chy129
 * @date 2025/6/22
 */
public class 买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {
        int res = 0, minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            res = Math.max(res, price - minPrice);
        }
        return res;
    }
}

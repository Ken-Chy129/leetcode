package leetcode.剑指offer;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/14 21:50
 */
public class Offer63_股票的最大利润 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int lowest = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - lowest);
            lowest = Math.min(prices[i], lowest);
        }
        return res;
    }
}

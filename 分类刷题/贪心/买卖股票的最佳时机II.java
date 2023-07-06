package leetcode.分类刷题.贪心;

/**
 * <pre>
 * 题目链接：<a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/">买卖股票的最佳时机II</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/25 22:22
 */
public class 买卖股票的最佳时机II {

    public int maxProfit(int[] prices) {
        int begin = 0, end = 0, profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] > prices[i]) {
                profit += prices[end] - prices[begin];
                begin = i;
            }
            end = i;
        }
        return profit;
    }
}

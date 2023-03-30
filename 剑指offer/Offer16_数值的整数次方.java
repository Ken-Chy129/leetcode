package leetcode.剑指offer;

/**
 * <pre>
 * <a href="https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/">数的整数次方</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/30 1:34
 */
public class Offer16_数值的整数次方 {

    
    public double myPow(double x, int n) {
        long cnt = n;
        double res = 1.0;
        if (cnt < 0) {
            cnt = -cnt;
            x = 1 / x;
        }
        while (cnt != 0) {
            if((cnt & 1) == 1) {
                res *= x;
            }
            x *= x;
            cnt >>= 1;
        }
        return res;
    }
    
}

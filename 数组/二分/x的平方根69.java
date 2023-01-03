package leetcode.数组.二分;

/**
 * <pre>
 * <p>求x的平方根，实际也是二分查找的一个变形</p>
 * 搜索区间从给定数组，编程1到x的区间
 * 不断二分该区间，对每次取的mid值进行平方，与x值进行对比决定下一个区间变换
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/2 15:47
 */
public class x的平方根69 {
    public int mySqrt(int x) {
        int left = 1, right = x, mid = 0; // mid=0解决不进入循环时(即x=0)的情况
        long pow = 0; // 需要设置为long类型防止溢出
        while (left <= right) {
            mid = (right - left) / 2 + left;
            pow = (long) mid * mid; // 需要先将一个mid转换为long类型，long*int才会为long类型，不然是溢出后的结果赋值给pow
            if (pow == x) {
                return mid;
            } else if (pow < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (pow <= x) {
            return mid;
        } else {
            return mid - 1;
        }
    }
    
}

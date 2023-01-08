package leetcode.哈希表;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * 根据题目我们不难看出对于任何一个数只有两种可能，变为1或一直循环（不可能变得无限大）
 * 那么判断是否处于循环我们首先可以想到把前面出现的数字记录到set中，后面如果再次遇到就说明出现循环
 * 同时我们还能联想到之前的环形链表问题，对于这类循环查找问题，我们可以使用快慢指针，如果出现循环快指针一定会与慢指针相遇
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/8 13:51
 */
public class 快乐数202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int r, k = n;
            n = 0;
            while (k != 0) {
                r = k % 10;
                k = k / 10;
                n += r * r;
            }
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }

    public boolean isHappy2(int n) {
        int slow = n, quick = n;
        while (quick != 1) {
            quick = getNext(getNext(quick));
            slow = getNext(slow);
            if (quick != 1 && quick == slow) {
                return false;
            }
        }
        return true;
    }
    
    public int getNext(int n) {
        int r, k=0;
        while (n != 0) {
            r = n % 10;
            n = n / 10;
            k += r * r;
        }
        return k;
    }
}

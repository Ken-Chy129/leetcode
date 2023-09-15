package leetcode.笔试.去哪儿;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/15 15:25
 */
public class Main2 {

    public int find (int n, int v, int[] a) {
        // write code here
        int l = 1, r = n;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (a[mid - 1] >= v) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (a[l - 1] == v) {
            return l;
        } else {
            return n + 1;
        }
    }
}

package leetcode.热门题目.动态规划;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/14 22:28
 */
public class 接雨水 {

    public int trap(int[] height) {
        int[] leftTop = new int[height.length];
        int[] rightTop = new int[height.length];
        leftTop[0] = height[0];
        rightTop[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightTop[i] = Math.max(rightTop[i + 1], height[i]);
        }
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            leftTop[i] = Math.max(leftTop[i - 1], height[i]);
            int min = Math.min(leftTop[i - 1], rightTop[i + 1]);
            res += ((min > height[i]) ? min - height[i] : 0);
        }
        return res;
    }

    public int trap1(int[] height) {
        Deque<Integer> deque = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!deque.isEmpty() && height[deque.peek()] < height[i]) {
                int top = deque.pop();
                if (deque.isEmpty()) {
                    break;
                }
                int left = deque.peek();
                res += (Math.min(height[left], height[i]) - height[top]) * (i - left - 1);
            }
            deque.push(i);
        }
        return res;
    }

    public int trap2(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        int leftTop = 0, rightTop = 0;
        while (left < right) {
            leftTop = Math.max(leftTop, height[left]);
            rightTop = Math.max(rightTop, height[right]);
            if (leftTop < rightTop) {
                res += leftTop - height[left]; // 对于left点来说，此时真正的rightTop不能确定，但是一定大于等于这里的rightTop，所以leftTop < rightTop时无需要考虑真正的rightTop是多少，反正一定大于leftTop，那么直接用leftTop计算即可
                ++left;
            } else {
                res += rightTop - height[right]; // 对于right点来说，rightTop是确定的，但是leftTop点不一定准确，但真正的leftTop一定大于等于这里的leftTop，所以当leftTop>=rightTop时，真正的leftTop自然也大于rightTop，那么我们无需考虑真正的值时多少，反正一定大于rightTop，那么直接用rightTop计算即可
                --right;
            }
        }
        return res;
    }
}

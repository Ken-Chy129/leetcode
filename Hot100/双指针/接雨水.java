package leetcode.Hot100.双指针;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/8/12 16:29
 */
public class 接雨水 {

    public int trap(int[] height) { // 按列求，每一列的值其实都等于这列左边和右边的最大边界中最矮的那个
        // 因为从左遍历到右，左边界最高好求，但是右边界最高不知道，所以需要提前去遍历一遍
        int[] leftTop = new int[height.length];
        int[] rightTop = new int[height.length];
        leftTop[0] = height[0];
        rightTop[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightTop[i] = Math.max(rightTop[i + 1], height[i]);
        }
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            leftTop[i] = Math.max(leftTop[i - 1], height[i]);
            int min = Math.min(leftTop[i - 1], rightTop[i + 1]);
            sum += ((min > height[i]) ? min - height[i] : 0);
        }
        return sum;
    }

    public int trap1(int[] height) { // 按列求，同样的思路，但我们会发现其实并不需要知道左右边界的值都是多少
        // 只需要知道其中较矮的那个的高度，因此不需要使用数组实现保存右边界各个最高值
        // 我们只需要双指针各自指向左右两边，如果左边指针对应的最大高度小，那么此时左边的是可求的（虽然此时右边没遍历完，但是反正已经存在比左边界还大的高度，那就不用管了，已经可以求了），反之右边是可求的
        int left = 0, right = height.length - 1;
        int leftTop = 0, rightTop = 0;
        int sum = 0;
        while (left < right) {
            leftTop = Math.max(leftTop, height[left]);
            rightTop = Math.max(rightTop, height[right]);
            if (leftTop < rightTop) {
                sum += leftTop - height[left];
                left++;
            } else {
                sum += rightTop - height[right];
                right--;
            }
        }
        return sum;
    }

    public int trap2(int[] height) {
        Deque<Integer> deque = new ArrayDeque<>();
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            while (!deque.isEmpty() && height[deque.peek()] < height[i]) {
                int top = deque.pop();
                if (deque.isEmpty()) {
                    break;
                }
                int left = deque.peek();
                sum += (Math.min(height[left], height[i]) - height[top]) * (i - left - 1);
            }
            deque.push(i);
        }
        return sum;
    }
}

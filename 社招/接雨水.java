package leetcode.社招;

/**
 * @author Ken-Chy129
 * @date 2025/6/22
 */
public class 接雨水 {

    public int trap(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = i - 1; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i + 1; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            int minHeight = Math.min(maxLeft, maxRight);
            if (minHeight > height[i]) {
                res += minHeight - height[i];
            }
        }
        return res;
    }

    public int trap2(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax > rightMax) {
                res += rightMax - height[right];
                right--;
            } else {
                res += leftMax - height[left];
                left++;
            }
        }
        return res;
    }
}

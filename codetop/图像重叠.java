package leetcode.codetop;

/**
 * <pre>
 * 题目链接：<a href="https://leetcode.cn/problems/image-overlap/">图像重叠</a>
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/21 17:33
 */
public class 图像重叠 {

    public static int largestOverlap(int[][] img1, int[][] img2) {
        int len = img1.length, res = 0;
        for (int i = 1 - len; i < len; i++) {
            for (int j = 1 - len; j < len; j++) {
                int tmp = 0;
                int xMin, xMax, yMin, yMax;
                if (i < 0) {
                    xMin = 0;
                    xMax = len + i;
                } else {
                    xMin = i;
                    xMax = len;
                }
                if (j < 0) {
                    yMin = 0;
                    yMax = len + j;
                } else {
                    yMin = j;
                    yMax = len;
                }
                for (int k = xMin; k < xMax; k++) {
                    for (int l = yMin; l < yMax; l++) {
                        tmp += img1[k - i][l - j] & img2[k][l];
                    }
                }
                res = Math.max(tmp, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        largestOverlap(new int[][]{{1, 1, 0}, {0, 1, 0}, {0, 1, 0}}, new int[][]{{0, 0, 0}, {0, 1, 1}, {0, 0, 1}});
    }
}

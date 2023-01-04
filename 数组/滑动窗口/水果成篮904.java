package leetcode.数组.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * <p>滑动窗口，使用两个指针表示左右边界</p>
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/4 10:50
 */
public class 水果成篮904 {
    
    public int totalFruit(int[] fruits) {
        // lst1表示第一个篮子装的水果种类，num1表示装的数量，kind表示已经装了的种类数
        // j指针移动结束时则结束计数并将本轮数量与历史最大数量比较得出最优解
        int lst1 = -1, num1 = 0, lst2 = -1, num2 = 0, kind = 0, ans = 0;
        for (int i=0, j=0; i<fruits.length; i++) {
            // 如果已收集种类数不超过2，则j移动
            while (kind <= 2 && j < fruits.length) {
                if (fruits[j] != lst1 && fruits[j] != lst2) {
                    if (kind == 2) { // 如果已经拿了两种水果，下一棵树是第三种水果则结束循环
                        break;
                    }
                    if (num1 == 0) {
                        lst1 = fruits[j++];
                        num1++;
                    } else {
                        lst2 = fruits[j++];
                        num2++;
                    }
                    kind++;
                } else if (fruits[j] == lst1) {
                    j++;
                    num1++;
                } else {
                    j++;
                    num2++;
                }
                ans = Math.max(j-i, ans);
            }
            // 循环结束时j指向下一个种类
            if (fruits[i] == lst1) {
                num1--;
                if (num1 == 0) { // 第一个盘子已经没装了，这时装的水果种类数减一，意味着j可以继续右移
                    kind--;
                }
            } else if (fruits[i] == lst2) {
                num2--;
                if (num2 == 0) {
                    kind--;
                }
            }
        }
        return ans;
    }
    
    // 使用Map进行处理，简化代码（逻辑相同）
    // 上法中的lst和num其实就是下面map中的key和value，kind就是map.size()
    // 因为map中封装了很多方法所以写出来的代码更简洁
    public int way2(int[] fruits) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (int i=0, j=0; i<fruits.length; i++) {
            cnt.put(fruits[i], cnt.getOrDefault(fruits[i], 0) + 1);
            while (cnt.size() > 2) {
                cnt.put(fruits[j], cnt.get(fruits[j]) - 1);
                if (cnt.get(fruits[j]) == 0) {
                    cnt.remove(fruits[j]);
                }
                j++;
            }
            ans = Math.max(ans, i-j+1);
        }
        return ans;
    }
}

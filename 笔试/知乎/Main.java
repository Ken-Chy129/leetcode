package leetcode.笔试.知乎;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/16 14:00
 */
public class Main {

    public int getTotalSalary (int[] salary, int[][] subordinate, int id) {
        // write code here[5000, 3000, 2000],[[2], [3], []],1
        int sum = salary[id - 1];
        for (int i = 1; i <= subordinate[id - 1].length; i++) {
            sum += getTotalSalary(salary, subordinate, subordinate[id - 1][i - 1]);
        }
        return sum;
    }
    
}

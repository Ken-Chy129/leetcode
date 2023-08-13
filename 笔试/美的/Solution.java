package leetcode.笔试.美的;


public class Solution {
    
    private int res;
    
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param matrix int整型二维数组 
     * @return int整型
     */
    public int minValue (int[][] matrix) {
        res = Integer.MAX_VALUE;
        dfs(matrix, 0, 0, 0);
        return res;
    }

    private void dfs(int[][]matrix, int i, int j, int value) {
        if (i >= matrix.length || j >= matrix[0].length) {
            return;
        }
        if (i == matrix.length - 1 && j == matrix[i].length - 1) {
            res = Math.min(res, value + matrix[i][j]);
        }
        dfs(matrix, i + 1, j, value + matrix[i][j]);
        dfs(matrix, i, j + 1, value + matrix[i][j]);
    }
}

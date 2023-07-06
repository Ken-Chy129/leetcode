package leetcode.美团;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/10 21:31
 */
public class 淘汰分数 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int minPeo = in.nextInt(), maxPeo = in.nextInt();
        Integer[] score = new Integer[total];
        for (int i=0; i<total; i++) {
            score[i] = in.nextInt();
        }
        Arrays.sort(score, (a, b) -> b - a);
        int minScoreOk = score[maxPeo]; // 正好过了maxPeo个人时的分数，即分数线要大于等于minScoreOk
        int maxScoreOk = score[minPeo - 1]; // 正好过了minPeo个人时的分数，即分数线要小于maxScoreOk
        int minScoreG = score[total - minPeo]; // 正好挂了minPeo个人时的分数，即分数线要大于等于minScoreG
        int maxScoreG = score[total - maxPeo - 1]; // 正好挂了maxPeo个人时的分数，即分数线要小于maxScoreG
        System.out.println(Math.max(minScoreG, minScoreOk) < Math.min(maxScoreG, maxScoreOk) ? Math.max(minScoreG, minScoreOk) : -1);
    }
}

package leetcode.美团;

import java.io.*;
import java.util.PriorityQueue;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/3/10 23:24
 */
public class 公司食堂 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int group = Integer.parseInt(reader.readLine());
        while (group > 0) {
            group--;
            int seatNum = Integer.parseInt(reader.readLine());
            String tmp = reader.readLine();
            int[] seatPeo = new int[seatNum];
            PriorityQueue<Integer> emptyQueue = new PriorityQueue<>();
            PriorityQueue<Integer> oneQueue = new PriorityQueue<>();
            for (int i = 0; i < seatNum; i++) {
                if (tmp.charAt(i) - 48 == 0) {
                    emptyQueue.offer(i);
                } else if (tmp.charAt(i) - 48 == 1) {
                    oneQueue.offer(i);
                }
            }
            int peo = Integer.parseInt(reader.readLine());
            char[] gender = reader.readLine().toCharArray();
            for (int i = 0; i < peo; i++) {
                Integer poll;
                if (gender[i] == 'M') {
                    if (oneQueue.isEmpty()) {
                        poll = emptyQueue.poll();
                        oneQueue.offer(poll);
                    } else {
                        poll = oneQueue.poll();
                    }
                    writer.write(String.valueOf(poll + 1));
                    writer.newLine();
                } else {
                    if (emptyQueue.isEmpty()) {
                        poll = oneQueue.poll();
                    } else {
                        poll = emptyQueue.poll();
                        oneQueue.offer(poll);
                    }
                    writer.write(String.valueOf(poll + 1));
                    writer.newLine();
                }
            }
        }
        writer.flush();
    }
}

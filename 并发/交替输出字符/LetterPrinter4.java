package leetcode.并发.交替输出字符;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/10 15:09
 */
public class LetterPrinter4 {

    private int cnt;

    public LetterPrinter4(int cnt) {
        this.cnt = cnt;
    }

    public static void main(String[] args) throws InterruptedException {
        LetterPrinter4 letterPrinter = new LetterPrinter4(100);
        for (int i = 0; i < 10; i++) {
            Thread aThread = new Thread(() -> letterPrinter.printLetter("A", null));
            Thread bThread = new Thread(() -> letterPrinter.printLetter("B", aThread));
            Thread cThread = new Thread(() -> letterPrinter.printLetter("C", bThread));
            aThread.start();
            bThread.start();
            cThread.start();
            cThread.join();
        }
    }

    public void printLetter(String letter, Thread thread) {
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(letter);
    }
}

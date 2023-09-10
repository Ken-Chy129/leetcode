package leetcode.并发.交替输出字符;

import java.util.concurrent.Semaphore;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/10 15:21
 */
public class LetterPrinter5 {

    private int cnt;

    public LetterPrinter5(int cnt) {
        this.cnt = cnt;
    }

    public static void main(String[] args) {
        LetterPrinter5 letterPrinter = new LetterPrinter5(10);
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);
        new Thread(() -> letterPrinter.printLetter("A", semaphoreA, semaphoreB)).start();
        new Thread(() -> letterPrinter.printLetter("B", semaphoreB, semaphoreC)).start();
        new Thread(() -> letterPrinter.printLetter("C", semaphoreC, semaphoreA)).start();
    }

    public void printLetter(String letter, Semaphore consume, Semaphore produce) {
        for (int i = 0; i < cnt; i++) {
            try {
                consume.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(letter);
            produce.release();
        }
    }
}

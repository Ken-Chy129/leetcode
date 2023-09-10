package leetcode.并发.交替输出字符;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/10 0:14
 */
public class LetterPrinter {
    private int printTimes;

    private int state;

    private Lock lock = new ReentrantLock();

    public LetterPrinter(int printTimes) {
        this.printTimes = printTimes;
    }

    public void printLetter(String letter, int target) {
        for (int i = 0; i < printTimes; ) {
            try {
                lock.lock();
                if (state % 3 == target) {
                    i++;
                    state++;
//                    System.out.println(letter);
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        LetterPrinter letterPrinter = new LetterPrinter(100);
        new Thread(() -> letterPrinter.printLetter("A", 0)).start();
        new Thread(() -> letterPrinter.printLetter("B", 1)).start();
        new Thread(() -> letterPrinter.printLetter("C", 2)).start();
    }
}

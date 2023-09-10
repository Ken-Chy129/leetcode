package leetcode.并发.交替输出字符;

import java.util.concurrent.CountDownLatch;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/10 0:37
 */
public class LetterPrinter2 {

    private int printTimes;

    private int state;
    
    private static final Object LOCK = new Object();
    
    public LetterPrinter2(int printTimes) {
        this.printTimes = printTimes;
    }

    public static void main(String[] args) throws InterruptedException {
        LetterPrinter2 letterPrinter = new LetterPrinter2(10);
        new Thread(() -> letterPrinter.printLetter("A", 0)).start();
        new Thread(() -> letterPrinter.printLetter("B", 1)).start();
        new Thread(() -> letterPrinter.printLetter("C", 2)).start();
    }
    
    public void printLetter(String letter, int target) {
        for (int i = 0; i < printTimes; ) {
//            synchronized (LOCK) {
                if (state % 3 == target) {
                    System.out.println(letter);
                    state++;
                    i++;
//                    LOCK.notifyAll();
                }
//            }
        }
    }
}

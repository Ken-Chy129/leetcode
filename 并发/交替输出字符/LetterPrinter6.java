package leetcode.并发.交替输出字符;

import java.util.concurrent.locks.LockSupport;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/10 15:58
 */
public class LetterPrinter6 {

    private int cnt;

    static Thread threadA, threadB, threadC;

    public LetterPrinter6(int cnt) {
        this.cnt = cnt;
    }

    public static void main(String[] args) {
        LetterPrinter6 letterPrinter = new LetterPrinter6(10);
        threadA = new Thread(() -> letterPrinter.printLetter("A", threadB));
        threadB = new Thread(() -> letterPrinter.printLetter("B", threadC));
        threadC = new Thread(() -> letterPrinter.printLetter("C", threadA));
        threadA.start();
        threadB.start();
        threadC.start();
        LockSupport.unpark(threadA);
    }

    public void printLetter(String letter, Thread toNotify) {
        for (int i = 0; i < cnt; i++) {
            LockSupport.park();
            System.out.println(letter);
            LockSupport.unpark(toNotify);
        }
    }
}

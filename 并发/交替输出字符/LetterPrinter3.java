package leetcode.并发.交替输出字符;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/10 14:10
 */
public class LetterPrinter3 {

    private static int state;
    
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition aCondition = lock.newCondition();
        Condition bCondition = lock.newCondition();
        Condition cCondition = lock.newCondition();
        new Thread(() -> {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    if (state % 3 == 0) {
                        i++;
                        state++;
                        System.out.println("A");
                        bCondition.signal();
                        if (i == 10) {
                            break;
                        }
                    }
                    aCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    if (state % 3 == 1) {
                        i++;
                        state++;
                        System.out.println("B");
                        cCondition.signal();
                        if (i == 10) {
                            break;
                        }
                    }
                    bCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    if (state % 3 == 2) {
                        i++;
                        state++;
                        System.out.println("C");
                        aCondition.signal();
                        if (i == 10) {
                            break;
                        }
                    }
                    cCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}

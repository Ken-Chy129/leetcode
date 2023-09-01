package leetcode.并发.单例;

/**
 * <pre>
 * 单例实现：懒汉式（双重检查锁定）
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/1 21:09
 */
public class Singleton {

    private Singleton() {
        
    }
    
    private static volatile Singleton INSTANCE;

    public static Singleton getSingleton() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}

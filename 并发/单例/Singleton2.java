package leetcode.并发.单例;

/**
 * <pre>
 * 单例实现：饿汉式
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/1 21:48
 */
public class Singleton2 {

    private Singleton2() {
        
    }
    
    private static final Singleton2 INSTANCE = new Singleton2();

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}

package leetcode.并发.单例;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/1 22:10
 */
public class Singleton4 {

    private Singleton4() {
        
    }

    private static class LAZY_HOLDER {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return LAZY_HOLDER.INSTANCE;
    }
    
}

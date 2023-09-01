package leetcode.并发.单例;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/1 21:50
 */
public enum Singleton3 {
    
    INSTANCE(1);

    final int code;
    
    Singleton3(int code) {
        this.code = code;
    }
}

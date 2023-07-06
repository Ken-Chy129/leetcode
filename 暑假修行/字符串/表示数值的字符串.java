package leetcode.暑假修行.字符串;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/7/6 16:04
 */
public class 表示数值的字符串 {

    public boolean isNumber(String s) {
        s = s.trim();
        boolean numFlag = false, dotFlag = false, eFlag = false;
        for (int i = 0; i < s.length(); i++) {
            // 出现数字
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numFlag = true;
            }
            // 正确的小数要求出现在E前面,即E还未出现，并且没出现过小数点
            else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
            }
            // 正确的E需要前面后面都有数，并且没有出现过E
            else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && numFlag && !eFlag) {
                eFlag = true;
                numFlag = false;
            }
            // 正确的正负号需要位于数字的前面，数字分为整数和小数，小数允许小数点前面没有数字，所以小数还需要特判
            // 即要么没有出现过小数点，如果出现了小数点则要求E也出现过了，防止.+1这种不合法的情况
            else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && !numFlag) {
                if (dotFlag && !eFlag) {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return numFlag;
    }
}

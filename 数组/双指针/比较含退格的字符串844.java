package leetcode.数组.双指针;

/**
 * <pre>
 * <p>退格有两种方式，一种是维护一个栈，需要额外的时间开销，另一种是双指针，并维护一个退格键数控制指针的移动</p>
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/3 13:17
 */
public class 比较含退格的字符串844 {
    public boolean backspaceCompare(String s, String t) {
//        return build(s).equals(build(t));
        int pos1 = s.length()-1, pos2 = t.length()-1;
        int flag1 = 0, flag2 = 0; // flag表示需要删除的元素数量
        while (pos1>=0 || pos2>=0) {
            while (pos1 >= 0) {
                if (s.charAt(pos1) == '#') { // 如果是#号则表示增加一个退格数，且指针前移
                    flag1++;
                    pos1--;
                } else if (flag1 > 0) { // 是正常字符且退格数还未清零，表示该字符会被删掉
                    flag1--;
                    pos1--;
                } else { // 不是退格，且退格数已经清零，说明这个字符有效的需要拿来比较的
                    break;
                }
            }
            // 下面这个循环同理，出循环后得到需要比较的字符
            while (pos2 >= 0) {
                if (t.charAt(pos2) == '#') {
                    flag2++;
                    pos2--;
                } else if (flag2 > 0) {
                    flag2--;
                    pos2--;
                } else {
                    break;
                }
            }
            if (pos1 >= 0 && pos2 >= 0) { // 位置是有效的，都大于等于0（即都还没遍历完字符串）
                if (s.charAt(pos1) != t.charAt(pos2)) { // 如果不同那么肯定字符串是不同的
                    return false;
                }
            } else if (pos1 >= 0 || pos2 >= 0) {
                // 如果有一个字符串遍历完了，另一个还没遍历完那么两个字符串肯定不相同
                // 因为没遍历完的那个字符串前面肯定还有一些有效字符
                // 不可能全是退格键，因为最近的连续退格键会在循环中删掉，出来的会是有效字符
                return false;
            }
            // 接着往前判断
            pos1--;
            pos2--;
        }
        // 两个字符串同时遍历完也没有出现不同的字符则两个字符串相等
        return true;
    }
    
    // 维护一个栈结构，非#字符即入栈，检测到#字符则将栈顶元素出栈，时间复杂度和空间复杂度都为O(n+m)
    public String build(String s) {
        StringBuffer str = new StringBuffer();
        int len = s.length();
        for (int i=0; i<len; i++) {
            if (s.charAt(i) != '#') {
                str.append(s.charAt(i));
            } else {
                if (!str.isEmpty()) {
                    str.deleteCharAt(str.length() - 1);
                }
            }
        }
        return str.toString();
    }
    
}

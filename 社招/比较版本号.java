package leetcode.社招;

/**
 * @author Ken-Chy129
 * @date 2025/6/22
 */
public class 比较版本号 {

    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0, version1Length = version1.length(), version2Length = version2.length();
        while (i < version1Length || j < version2Length) {
            int value1 = 0, value2 = 0;
            for (; i < version1Length && version1.charAt(i) != '.'; i++) {
                value1 = value1 * 10 + (version1.charAt(i) - '0');
            }
            for (; j < version2Length && version2.charAt(j) != '.'; j++) {
                value2 = value2 * 10 + (version2.charAt(j) - '0');
            }
            if (value1 != value2) {
                return value1 > value2 ? 1 : -1;
            }
            i++; j++;
        }
        return 0;
    }
}

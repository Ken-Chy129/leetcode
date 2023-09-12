package leetcode.笔试.百度;

import java.util.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/9/12 19:55
 */
public class Main3 {

    static class Node {
        String name;
        String value;

        public Node(String name, String value) {
            this.name = name;
            this.value = value;
        }
    }

    static List<Node> nameMap = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        while (q-- != 0) {
            int op = in.nextInt();
            in.nextLine();
            if (op == 1) {
                String[] cmd = in.nextLine().split(" ");
                String name;
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < cmd.length; i++) {
                    sb.append(cmd[i]).append(" ");
                }
                String[] signature = sb.toString().split("\\(");
                name = signature[0];
                StringBuilder parametersTypes = new StringBuilder();
                if (signature[1].indexOf(')') != 0) {
                    String[] parameters = signature[1].split(",");
                    for (String parameter : parameters) {
                        parametersTypes.append(parameter.split(" ")[0]);
                    }
                }
                if (isExist(name, parametersTypes.toString())) {
                    System.out.println("method " + name + " is already defined.");
                    continue;
                } else {
                    nameMap.add(new Node(name, parametersTypes.toString()));
                }
            } else {
                String[] cmd = in.nextLine().split("\\(");
                if (!containsKey(cmd[0])) {
                    System.out.println("cannot find symbol " + cmd[0] + ".");
                    continue;
                }
                StringBuilder parametersTypes = new StringBuilder();
                if (cmd[1].indexOf(")") != 0) {
                    cmd[1] = cmd[1].substring(0, cmd[1].length() - 1);
                    String[] parameters = cmd[1].split(",");
                    for (String parameter : parameters) {
                        parametersTypes.append(parameter.split(" ")[0]);
                    }
                }
                if (!isExist(cmd[0], parametersTypes.toString())) {
                    System.out.println("method " + cmd[0] + " cannot be applied to given types.");
                    continue;
                }
            }
            System.out.println("ok.");
        }
    }

    private static boolean isExist(String key, String value) {
        for (int i = 0; i < nameMap.size(); i++) {
            if (nameMap.get(i).name.equals(key)) {
                if (nameMap.get(i).value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean containsKey(String key) {
        for (int i = 0; i < nameMap.size(); i++) {
            if (nameMap.get(i).name.equals(key)) {
                return true;
            }
        }
        return false;
    }
}

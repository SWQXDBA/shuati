package 每日一题;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 找出字符串中只出现一次的字符 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();
            boolean found = false;
            Set<Character> notThis = new HashSet<>();
            for (int i = 0; i < chars.length; i++) {
                boolean isThis = true;
                if (notThis.contains(chars[i])) {
                    continue;
                }
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] == chars[j]) {
                        isThis = false;
                        notThis.add(chars[i]);
                        break;
                    }
                }
                if (isThis) {
                    found = true;
                    System.out.println(chars[i]);
                    break;
                }
            }
            if (!found) {
                System.out.println(-1);
            }


        }
    }
}

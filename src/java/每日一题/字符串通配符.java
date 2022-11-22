package 每日一题;

import java.util.Scanner;

public class 字符串通配符 {
    public static boolean isDaXieZiMu(char c) {
        return c >= 'A' && c <= 'Z';

    }

    public static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isXiaoXieZiMu(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean isZiMu(char c) {
        return isDaXieZiMu(c) || isXiaoXieZiMu(c);
    }

    static boolean equal(char c1, char c2) {

        if (isZiMu(c1) && isZiMu(c2) && Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
            return true;
        }
        return c1 == c2;
    }

    static boolean tryCompare(char[] chars1, char[] chars2, int ptr1, int ptr2) {
        if (ptr1 >= chars1.length && ptr2 >= chars2.length) {
            return true;
        }
        if (ptr1 >= chars1.length || ptr2 >= chars2.length) {
            return false;
        }
        char c1 = chars1[ptr1], c2 = chars2[ptr2];
        if (equal(c1, c2) || c1 == '?' && (isZiMu(c2) || isNumber(c2))) {
            return tryCompare(chars1, chars2, ptr1 + 1, ptr2 + 1);
        }
        if (c1 == '*') {
            while (ptr1 < chars1.length && chars1[ptr1] == '*') {
                ptr1++;
            }
            ptr1--;
            return tryCompare(chars1, chars2, ptr1 + 1, ptr2)//匹配0个
                    || tryCompare(chars1, chars2, ptr1 + 1, ptr2 + 1)//匹配1个
                    || tryCompare(chars1, chars2, ptr1, ptr2 + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            char[] chars1 = str1.toCharArray();
            char[] chars2 = str2.toCharArray();
            System.out.println(tryCompare(chars1, chars2, 0, 0));
        }
    }
}

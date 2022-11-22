package 每日一题;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 字符串的最长公共子串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            if (str2.length() < str1.length()) {
                String t = str1;
                str1 = str2;
                str2 = t;
            }
            Map<Integer, String> map = new HashMap<>();
            char[] chars1 = str1.toCharArray();
            char[] chars2 = str2.toCharArray();
            for (int i = 0; i < str1.length(); i++) {
                for (int j = 0; j < str2.length(); j++) {
                    String s = getSub(chars1, chars2, i, j);
                    if (!map.containsKey(s.length())) {
                        map.put(s.length(), s);
                    }

                }
            }
            int max = 0;
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                if (entry.getKey() > max) {
                    max = entry.getKey();
                }
            }
            System.out.println(map.get(max));

        }
    }

    public static String getSub(char[] str1, char[] str2, int index1, int index2) {
        StringBuilder ret = new StringBuilder();
        while (index1 < str1.length && index2 < str2.length) {
            if (str1[index1] == str2[index2]) {
                ret.append(str1[index1]);
                index1++;
                index2++;
            } else {
                break;
            }
        }

        return ret.toString();
    }
}

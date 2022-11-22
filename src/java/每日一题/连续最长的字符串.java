package 每日一题;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 连续最长的字符串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();
            int cnt = 0;
            Map<Integer, String> map = new HashMap<>();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < chars.length - 1; i++) {
                stringBuilder.append(chars[i]);
                cnt++;
                if (chars[i + 1] - chars[i] != 1 || i + 1 == chars.length - 1) {
                    if (i + 1 == chars.length - 1) {
                        stringBuilder.append(chars[i + 1]);
                    }
                    map.put(cnt, stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                    cnt = 0;
                }
            }


            int max = 0;
            for (Integer integer : map.keySet()) {
                if (max < integer) {
                    max = integer;
                }
            }
            System.out.println(map.get(max));


        }
    }
}

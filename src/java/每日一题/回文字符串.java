package 每日一题;

import java.util.Scanner;

public class 回文字符串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();

            String str2 = scanner.nextLine();
            int cnt = 0;
            int i = 1;


            //插在中间
            for (int j = 0; i < str1.length(); i++) {
                String strLeft = str1.substring(0, i);
                String strRight = str1.substring(i);
                String test = strLeft + str2 + strRight;
                //   System.out.println(test);
                if (isHuiWen(test)) {
                    cnt++;
                }
            }
            //插在后面
            if (isHuiWen(str1 + str2)) {
                cnt++;
            }
            //插在前面
            if (isHuiWen(str2 + str1)) {
                cnt++;
            }
            System.out.println(cnt);

        }
    }

    public static boolean isHuiWen(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left <= right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

package 每日一题;

import java.util.Scanner;

public class 删除公共字符 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            for (char c : str2.toCharArray()) {
                str1 = str1.replace(c + "", "");
            }
            System.out.println(str1);
        }
    }
}

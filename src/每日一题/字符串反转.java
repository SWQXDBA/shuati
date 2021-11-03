package 每日一题;

import java.util.Scanner;

public class 字符串反转 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(new StringBuilder(s).reverse().toString());
        }
    }
}

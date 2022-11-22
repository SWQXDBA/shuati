package 每日一题;

import java.util.Scanner;

public class 数根 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();

            System.out.println(getNumberRoot(str));
        }
    }

    public static long getNumberRoot(String str) {
        long number = 0;
        for (char c : str.toCharArray()) {
            number += Long.parseLong("" + c);
        }
        if (number < 10) {
            return number;
        }
        return getNumberRoot("" + number);
    }

}

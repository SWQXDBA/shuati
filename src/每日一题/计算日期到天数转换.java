package 每日一题;

import java.util.Scanner;

public class 计算日期到天数转换 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int year, day, month;
            year = scanner.nextInt();
            month = scanner.nextInt();
            day = scanner.nextInt();
            System.out.println(outday(year, month, day));
        }
    }

    public static int outday(int year, int month, int day) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            days[1] = 29;
        }
        if (month < 1 || month > 12 || day <= 0 || day > days[month - 1]) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < month - 1; i++) {
            res += days[i];
        }
        res += day;
        return res;
    }
}


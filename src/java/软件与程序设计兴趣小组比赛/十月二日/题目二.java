package 软件与程序设计兴趣小组比赛.十月二日;

import java.util.Scanner;

public class 题目二 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int step = 0;
            while (n != 1) {
                step++;
                if (n % 2 == 0) {
                    n /= 2;
                } else {
                    n = (3 * n + 1) / 2;
                }
            }
            System.out.println(step);
        }
    }


}

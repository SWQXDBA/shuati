package 每日一题;


import java.util.Scanner;

public class 最小公倍数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final int num1 = scanner.nextInt();
            final int num2 = scanner.nextInt();
            int a = Math.max(num1, num2);
            int b = Math.min(num1, num2);

            while (a % b != 0) {
                int t = a % b;
                a = b;
                b = t;
            }
            System.out.println("最大公约数:" + b);
            System.out.println("最小公倍数:" + (num1 * num2 / b));

        }
    }
}

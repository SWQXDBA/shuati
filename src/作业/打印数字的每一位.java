package 作业;

import java.util.Scanner;

public class 打印数字的每一位 {
    static void printnum(int n) {
        if (n < 10) {
            System.out.print(n + " ");
            return;
        }
        printnum(n / 10);
        System.out.print(n % 10 + " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        printnum(num);

    }
}

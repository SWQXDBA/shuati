package 每日一题;

import java.util.Scanner;

public class 进制转换 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        System.out.println(Integer.toString(M, N));
    }
}

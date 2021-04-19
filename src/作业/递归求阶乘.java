package 作业;

import java.util.Scanner;

public class 递归求阶乘 {
    static long jie(long n) {
        if (n == 1) {
            return 1;
        }
        return n * jie(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(jie(scanner.nextInt()));
    }
}

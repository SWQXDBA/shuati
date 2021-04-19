package 作业;

import java.util.Scanner;

public class 返回的数字之和 {
    static int numberSums(int n) {
        if (n < 10)
            return n;
        return numberSums(n / 10) + n % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(numberSums(num));
    }

}

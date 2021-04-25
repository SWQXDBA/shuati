package 每日一题;

import java.util.Scanner;

public class 查找组成一个偶数最接近的两个素数 {
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int mid = num / 2;
            int right = num - mid;
            while (mid >= 2) {
                if (isPrime(mid) && isPrime(right)) {
                    System.out.println(mid);
                    System.out.println(right);
                    break;
                }
                mid--;
                right++;
            }
        }
    }
}

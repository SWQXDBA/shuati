import java.util.Scanner;

public class N的阶乘 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        for (long i = n - 1; i >= 1; i--) {
            n *= i;
        }
        System.out.println(n);

    }
}

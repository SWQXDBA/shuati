import java.util.Scanner;

public class 求三个数的最大值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println(Math.max(Math.max(a, b), c));
    }
}

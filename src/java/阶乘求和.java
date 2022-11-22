import java.util.Scanner;

public class 阶乘求和 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        long res = 0;
        long now = 1;
        for (int i = 1; i <= n; i++) {
            now *= i;
            res += now;
        }
        System.out.println(res);
    }
}

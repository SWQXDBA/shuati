package 每日一题;


import java.util.Scanner;

public class 最小公倍数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a, b;
            a = scanner.nextInt();
            b = scanner.nextInt();
            int ta = a;
            int tb = b;
            if (a < b) {
                int t = a;
                a = b;
                b = t;
            }
            while (a % b != 0) {
                int t = a % b;
                a = b;
                b = t;
            }
            System.out.println(ta * tb / b);
        }
    }
}

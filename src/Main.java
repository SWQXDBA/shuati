import java.util.Scanner;

public class Main {


    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        while (n != m) {
            if (n > m)
                n /= 2;
            else
                m /= 2;
        }
        System.out.println(n);
    }

}


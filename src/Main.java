import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(Integer.toString(x, n));
            System.out.println(change(x, n));
        }
    }

    public static String change(int x, int n) {
        StringBuilder stringBuilder = new StringBuilder();
     

        while (x != 0) {
            int cnt = x % n;
            if (cnt < 9) {
                stringBuilder.append(cnt);
            } else {
                stringBuilder.append((char) ('A' + cnt - 10));
            }
            x /= n;

        }
        stringBuilder.reverse();

        return stringBuilder.toString();
    }


}
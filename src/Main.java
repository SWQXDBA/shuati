import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();
            long num = 0;
            long flag = 1;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '+')
                    continue;
                if (chars[i] == '-') {
                    flag = -1;
                    continue;
                }

                if (chars[i] < '0' || chars[i] > '9') {
                    num = 0;
                    break;
                }
                num += chars[i] - '0';
                if (i != chars.length - 1)
                    num *= 10;
            }
            num *= flag;
            System.out.println(num);
        }
    }
}

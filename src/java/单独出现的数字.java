import java.util.Scanner;

public class 单独出现的数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        while (sc.hasNext()) {
            first ^= sc.nextInt();
        }
        System.out.println(first);
    }
}

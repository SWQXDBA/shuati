package 作业.暑假21年;

import java.util.Scanner;

public class 二进制中1的个数 {
    static int function(int num) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & 1) == 1) {
                sum++;
            }
            num >>= 1;  //--
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            System.out.println(function(x));
        }
    }

}

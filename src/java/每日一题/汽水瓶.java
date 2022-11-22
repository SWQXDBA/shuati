package 每日一题;

import java.util.Scanner;

public class 汽水瓶 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int cnt = scanner.nextByte();
            if (cnt != 0) {
                System.out.println(drink(cnt));
            }

        }
    }

    public static int drink(int cnt) {
        if (cnt == 2) {
            return 1;
        }
        if (cnt < 2) {
            return 0;
        }
        int ret = cnt / 3;
        cnt = cnt % 3;
        cnt += ret;
        return ret + drink(cnt);
    }
}

package 每日一题;

import java.util.Scanner;

public class 不要二 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            boolean[][] arr = new boolean[1002][1002];
//        for (int i = 0; i < 1000; i++) {
//            for (int j = 0; j < 1000; j++) {
//                    arr[i][j]=false;
//            }
//        }
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == false) {
                        arr[i + 2][j] = true;
                        arr[i][j + 2] = true;
                    }

                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == false)
                        cnt++;
                }
            }
            System.out.println(cnt);
        }


    }
}
